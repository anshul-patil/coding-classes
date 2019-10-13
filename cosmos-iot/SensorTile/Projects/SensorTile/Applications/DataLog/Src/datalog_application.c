/**
 ******************************************************************************
 * @file    DataLog/Src/datalog_application.c
 * @author  Central Labs
 * @version V1.1.0 - v2 High Pass Filter on only Displacement
 * @date    27-Sept-2016
 * @brief   This file provides a set of functions to handle the datalog
 *          application.
 ******************************************************************************
 * @attention
 *
 * <h2><center>&copy; COPYRIGHT(c) 2014 STMicroelectronics</center></h2>
 *
 * Licensed under MCD-ST Liberty SW License Agreement V2, (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *        http://www.st.com/software_license_agreement_liberty_v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************
 */

/* Includes ------------------------------------------------------------------*/
#include "datalog_application.h"
#include "main.h"
#include "string.h"
#include "SensorTile.h"
#include <math.h>

/* FatFs includes component */
#include "ff_gen_drv.h"
#include "sd_diskio.h"

FRESULT res; /* FatFs function common result code */
uint32_t byteswritten, bytesread; /* File write/read counts */
FATFS SDFatFs; /* File system object for SD card logical drive */
FIL MyFile; /* File object */
char SDPath[4]; /* SD card logical drive path */

volatile uint8_t SD_Log_Enabled = 0;
static uint8_t verbose = 0; /* Verbose output to UART terminal ON/OFF. */

static char dataOut[256];
char newLine[] = "\r\n";

// global variables for displacement
/*
 * Use the following variables to compute kinematic variables.
 */
float velocity_x = 0, velocity_x_prev = 0;
float velocity_y = 0, velocity_y_prev = 0;
float velocity_x_filter, velocity_x_filter_prev;
float velocity_y_filter, velocity_y_filter_prev;

float displacement_x = 0, displacement_x_prev = 0;
float displacement_y = 0, displacement_y_prev = 0;
float displacement_x_filter = 0, displacement_x_filter_prev = 0;
float displacement_y_filter = 0, displacement_y_filter_prev = 0;

float accel_x_direct, accel_y_direct;
float accel_x_direct_prev = 0, accel_y_direct_prev = 0;
float accel_x_direct_filter = 0, accel_y_direct_filter = 0;
float accel_x_direct_filter_prev = 0, accel_y_direct_filter_prev = 0;

/*
 * You may declare variables should you need more.
 */


/**
 * @brief  Start SD-Card demo
 * @param  None
 * @retval None
 */
void DATALOG_SD_Init(void) {
	char SDPath[4];

	if (FATFS_LinkDriver(&SD_Driver, SDPath) == 0) {
		/* Register the file system object to the FatFs module */
		if (f_mount(&SDFatFs, (TCHAR const*) SDPath, 0) != FR_OK) {
			/* FatFs Initialization Error */
			while (1) {
				BSP_LED_On(LED1);
				HAL_Delay(500);
				BSP_LED_Off(LED1);
				HAL_Delay(100);
			}
		}
	}
}

/**
 * @brief  Start SD-Card demo
 * @param  None
 * @retval None
 */
uint8_t DATALOG_SD_Log_Enable(void) {
	static uint16_t sdcard_file_counter = 0;
	char header[] =
			"Timestamp\tAccX [mg]\tAccY [mg]\tAccZ [mg]\tGyroX [mdps]\tGyroY [mdps]\tGyroZ [mdps]\tMagX [mgauss]\tMagY [mgauss]\tMagZ [mgauss]\tP [mB]\tT [�C]\tH [%]\tVOL [mV]\tBAT [%]\r\n";
	uint32_t byteswritten; /* written byte count */
	char file_name[30] = { 0 };

	/* SD SPI CS Config */
	SD_IO_CS_Init();

	sprintf(file_name, "%s%.3d%s", "SensorTile_Log_N", sdcard_file_counter,
			".tsv");
	sdcard_file_counter++;

	HAL_Delay(100);

	if (f_open(&MyFile, (char const*) file_name, FA_CREATE_ALWAYS | FA_WRITE)
			!= FR_OK) {
		return 0;
	}

	if (f_write(&MyFile, (const void*) &header, sizeof(header) - 1,
			(void *) &byteswritten) != FR_OK) {
		return 0;
	}
	return 1;
}

/**
 * @brief  Disable SDCard Log
 * @param  None
 * @retval None
 */
void DATALOG_SD_Log_Disable(void) {
	f_close(&MyFile);

	/* SD SPI Config */
	SD_IO_CS_DeInit();
}

/**
 * @brief  Write New Line to file
 * @param  None
 * @retval None
 */
void DATALOG_SD_NewLine(void) {
	uint32_t byteswritten; /* written byte count */
	f_write(&MyFile, (const void*) &newLine, 2, (void *) &byteswritten);
}

/**
 * @brief  Handles the time+date getting/sending
 * @param  None
 * @retval None
 */
void RTC_Handler(RTC_HandleTypeDef *RtcHandle) {
	uint8_t subSec = 0;
	RTC_DateTypeDef sdatestructureget;
	RTC_TimeTypeDef stimestructure;

	HAL_RTC_GetTime(RtcHandle, &stimestructure, FORMAT_BIN);
	HAL_RTC_GetDate(RtcHandle, &sdatestructureget, FORMAT_BIN);
	subSec = ((((((int) RTC_SYNCH_PREDIV) - ((int) stimestructure.SubSeconds))
			* 100) / ( RTC_SYNCH_PREDIV + 1)) & 0xff);

	if (SendOverUSB) /* Write data on the USB */
	{
		/*
		 * Remove writing of time stamp to avoid interference with graphics systems reading output data stream
		 */
		//   sprintf( dataOut, "\nTimeStamp: %02d:%02d:%02d.%02d", stimestructure.Hours, stimestructure.Minutes, stimestructure.Seconds, subSec );
		//   CDC_Fill_Buffer(( uint8_t * )dataOut, strlen( dataOut ));
	} else if (SD_Log_Enabled) /* Write data to the file on the SDCard */
	{
		uint8_t size;
		size = sprintf(dataOut, "%02d:%02d:%02d.%02d\t", stimestructure.Hours,
				stimestructure.Minutes, stimestructure.Seconds, subSec);
		res = f_write(&MyFile, dataOut, size, (void *) &byteswritten);
	}
}

/**
 * @brief  Handles the accelerometer axes data getting/sending
 * @param  handle the device handle
 * @retval None
 */
void Accelero_Sensor_Handler(void *handle, uint32_t msTick,
		uint32_t *msTickStateChange, uint8_t *state) {

	uint8_t who_am_i;
	float odr;
	float fullScale;
	uint8_t id;
	SensorAxes_t acceleration;
	uint8_t status;
	int32_t d1, d2;

	int32_t entry_state = 0;

	uint32_t reset_time = 4000;
	uint32_t dwell_time = 1000;
	uint32_t error_time = 3000;
	uint32_t return_to_start_time = 4000;

	/*
	 * Variables for floatTo_Int() execution
	 */

	int32_t d1_x, d2_x;
	int32_t d1_v, d2_v, d1_ax, d2_ax, d1_df, d2_df;
	int32_t d1_ay, d2_ay, d1_dy, d2_dy;

	/*
	 * Sampling period value set to 0.02 seconds
	 *
	 * Sample period is set with reference to DATA_PERIOD_MS in main.c
	 *
	 */

	float Tsample = 0.02;

	/*
	 * High Pass Filter coefficients for filter operating on velocity and displacement
	 */

	float fo_h = 0.3;
	float Wo_h, IWon_h, iirh_0, iirh_1, iirh_2;

	Wo_h = 2 * 3.141592654 * fo_h;
	IWon_h = 2 / (Wo_h * Tsample);
	iirh_0 = 1 - 1 / (1 + IWon_h);
	iirh_1 = -iirh_0;
	iirh_2 = (1 / (1 + IWon_h)) * (1 - IWon_h);

	BSP_ACCELERO_Get_Instance(handle, &id);

	BSP_ACCELERO_IsInitialized(handle, &status);

	if (status == 1) {
		if (BSP_ACCELERO_Get_Axes(handle, &acceleration) == COMPONENT_ERROR) {
			acceleration.AXIS_X = 0;
			acceleration.AXIS_Y = 0;
			acceleration.AXIS_Z = 0;
		}

		if (SendOverUSB) /* Write data on the USB */
		{

			/*
						 * High pass filter applied to acceleration
						 */
						accel_x_direct = (float) acceleration.AXIS_X;
						accel_x_direct_filter = iirh_0 * accel_x_direct
								+ iirh_1 * accel_x_direct_prev
								- iirh_2 * accel_x_direct_filter_prev;
						accel_x_direct_prev = accel_x_direct;

						accel_y_direct = (float) acceleration.AXIS_Y;
						accel_y_direct_filter = iirh_0 * accel_y_direct
								+ iirh_1 * accel_y_direct_prev
								- iirh_2 * accel_y_direct_filter_prev;
						accel_y_direct_prev = accel_y_direct;

						/*
						 * Integration of acceleration
						 */
						velocity_x = velocity_x
								+ (accel_x_direct_filter + accel_x_direct_filter_prev)
										* 9.81 * Tsample / 2; // 1 mg = 9.81 mm/s^2
						accel_x_direct_filter_prev = accel_x_direct_filter;

						velocity_y = velocity_y
								+ (accel_y_direct_filter + accel_y_direct_filter_prev)
										* 9.81 * Tsample / 2; // 1 mg = 9.81 mm/s^2
						accel_y_direct_filter_prev = accel_y_direct_filter;

						/*
						 * High pass filter applied to velocity
						 */

						velocity_x_filter = velocity_x * iirh_0 + velocity_x_prev * iirh_1
								- velocity_x_filter_prev * iirh_2;
						velocity_x_filter_prev = velocity_x_filter;

						velocity_y_filter = velocity_y * iirh_0 + velocity_y_prev * iirh_1
								- velocity_y_filter_prev * iirh_2;
						velocity_y_filter_prev = velocity_y_filter;
						/*
						 * Integration of velocity
						 */

						displacement_x = displacement_x
								+ (velocity_x_filter + velocity_x_filter_prev) * Tsample / 2;
						velocity_x_prev = velocity_x;

						displacement_y = displacement_y
								+ (velocity_y_filter + velocity_y_filter_prev) * Tsample
										/ 2;
						velocity_y_prev = velocity_y;

						/*
						 * High pass filter applied to displacement
						 */

						displacement_x_filter = displacement_x * iirh_0
								+ displacement_x_prev * iirh_1
								- displacement_x_filter_prev * iirh_2;
						displacement_x_prev = displacement_x;
						displacement_x_filter_prev = displacement_x_filter;

						displacement_y_filter = displacement_y * iirh_0
								+ displacement_y_prev * iirh_1
								- displacement_y_filter_prev * iirh_2;
						displacement_y_prev = displacement_y;
						displacement_y_filter_prev = displacement_y_filter;

			/*
			 * Assignment of integer values for output (only integer part of value is supplied due to
			 * communication rate limits)
			 *
			 */

			floatToInt((accel_x_direct), &d1_ax, &d2_ax, 4);
			floatToInt(accel_x_direct_filter, &d1_x, &d2_x, 4);
			floatToInt(velocity_x_filter, &d1_v, &d2_v, 4);
			floatToInt(displacement_x_filter, &d1_df, &d2_df, 4);

			floatToInt((accel_y_direct), &d1_ay, &d2_ay, 4);
			floatToInt(displacement_y_filter, &d1_dy, &d2_dy, 4);

			/*
			 * The function Accelero_Sensor_Handler is called each DATA_PERIOD_MS.  Thus, the operations in this
			 * function execute according to the interval of Tsample.
			 */

			/*
			 * Data transmission
			 * Note that during each 10ms period, less than 10 characters may be transmitted at the rate of 9600
			 * Baud and at 10 bits per character.
			 *
			 * Sample Rate is set to 20 milliseconds with the assignment of DATA_PERIOD_MS in main.c and corresponding
			 * Tsample in this source file datalog.c
			 *
			 * Thus, communication payload per cycle must be reduced to ensure that no more than 15 characters are
			 * transmitted during each cycle for a data period of DATA_PERIOD_MS = 20 or 7 characters for a
			 * DATA_PERIOD_MS of 10.  Adjustments in development must be made if DATA_PERIOD_MS is reduced.
			 */

			/*
			 * Data reporting includes tab separated values with:
			 *
			 * X-Displacement	Y-Displacement	State	Notification
			 *
			 * States number 0 through 3
			 *
			 * Notifications include
			 * 	- L corresponding to detection of "L" motion with left directed lower motion
			 *  - R corresponding to detection of "L" motion with right directed lower motion
			 *  - N corresponding to detection of Not Valid motion within time interval
			 *  - W corresponding to requirement to WAIT for displacement values to relax to near zero
			 *
			 * Note that a valid "L" motion begins with vertical motion in positive Y of greater than 15 cm
			 * while X displacement magnitude is less than 10 cm.
			 *
			 * Also, a valid motion requires that there is a dwell_time of 2 seconds after the termination
			 * of the vertical motion and prior to the horizontal motion (in positive or negative X direction)
			 *
			 * When horizontal motion occurs, Y motion magnitude must be less than 10 cm.
			 *
			 * The Wait notification condition is entered when the displacement values are greater than 10 cm
			 * while in the State 0.
			 *
			 */

			/*
			 * Report displacement and state data
			 */

			sprintf(dataOut, "%i\t%i\t%i", (int) (d1_df), (int) (d1_dy),
					*state);
			CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

			/*
			 * Design state machine through this switch statement.
			 */
			switch (*state) {
			case (0):


			default:
				break;

			}

			/*
			 * If no transitions are detected, the return to state 0
			 * occurs after after time reset_time
			 *
			 */

			if ((msTick - *msTickStateChange) > reset_time) {
				*state = 0;
			}

			/*
			 * Add the closing carriage return and line feed to the data line
			 */

			sprintf(dataOut, "\r\n");
			CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

			/*
			 * Following code is part of primary Datalog routine and not associated
			 * with this motion pattern detection above
			 */

			if (verbose == 1) {
				if (BSP_ACCELERO_Get_WhoAmI(handle, &who_am_i)
						== COMPONENT_ERROR) {
					sprintf(dataOut, "WHO AM I address[%d]: ERROR\n", id);
				} else {
					sprintf(dataOut, "WHO AM I address[%d]: 0x%02X\n", id,
							who_am_i);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

				if (BSP_ACCELERO_Get_ODR(handle, &odr) == COMPONENT_ERROR) {
					sprintf(dataOut, "ODR[%d]: ERROR\n", id);
				} else {
					floatToInt(odr, &d1, &d2, 3);
					sprintf(dataOut, "ODR[%d]: %d.%03d Hz\n", (int) id,
							(int) d1, (int) d2);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

				if (BSP_ACCELERO_Get_FS(handle, &fullScale)
						== COMPONENT_ERROR) {
					sprintf(dataOut, "FS[%d]: ERROR\n", id);
				} else {
					floatToInt(fullScale, &d1, &d2, 3);
					sprintf(dataOut, "FS[%d]: %d.%03d g\n", (int) id, (int) d1,
							(int) d2);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));
			}
		} else if (SD_Log_Enabled) /* Write data to the file on the SDCard */
		{
			uint8_t size;
			size = sprintf(dataOut, "%d\t%d\t%d\t", (int) acceleration.AXIS_X,
					(int) acceleration.AXIS_Y, (int) acceleration.AXIS_Z);
			res = f_write(&MyFile, dataOut, size, (void *) &byteswritten);
		}

	}
}

/**
 * @brief  Handles the gyroscope axes data getting/sending
 * @param  handle the device handle
 * @retval None
 */
void Gyro_Sensor_Handler(void *handle) {

	uint8_t who_am_i;
	float odr;
	float fullScale;
	uint8_t id;
	SensorAxes_t angular_velocity;
	uint8_t status;
	int32_t d1, d2;

	BSP_GYRO_Get_Instance(handle, &id);

	BSP_GYRO_IsInitialized(handle, &status);

	if (status == 1) {
		if (BSP_GYRO_Get_Axes(handle, &angular_velocity) == COMPONENT_ERROR) {
			angular_velocity.AXIS_X = 0;
			angular_velocity.AXIS_Y = 0;
			angular_velocity.AXIS_Z = 0;
		}

		if (SendOverUSB) /* Write data on the USB */
		{
			sprintf(dataOut, "\n\rGYR_X: %d, GYR_Y: %d, GYR_Z: %d",
					(int) angular_velocity.AXIS_X,
					(int) angular_velocity.AXIS_Y,
					(int) angular_velocity.AXIS_Z);
			CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

			if (verbose == 1) {
				if (BSP_GYRO_Get_WhoAmI(handle, &who_am_i) == COMPONENT_ERROR) {
					sprintf(dataOut, "WHO AM I address[%d]: ERROR\n", id);
				} else {
					sprintf(dataOut, "WHO AM I address[%d]: 0x%02X\n", id,
							who_am_i);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

				if (BSP_GYRO_Get_ODR(handle, &odr) == COMPONENT_ERROR) {
					sprintf(dataOut, "ODR[%d]: ERROR\n", id);
				} else {
					floatToInt(odr, &d1, &d2, 3);
					sprintf(dataOut, "ODR[%d]: %d.%03d Hz\n", (int) id,
							(int) d1, (int) d2);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

				if (BSP_GYRO_Get_FS(handle, &fullScale) == COMPONENT_ERROR) {
					sprintf(dataOut, "FS[%d]: ERROR\n", id);
				} else {
					floatToInt(fullScale, &d1, &d2, 3);
					sprintf(dataOut, "FS[%d]: %d.%03d dps\n", (int) id,
							(int) d1, (int) d2);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));
			}
		} else if (SD_Log_Enabled) /* Write data to the file on the SDCard */
		{
			uint8_t size;
			size = sprintf(dataOut, "%d\t%d\t%d\t",
					(int) angular_velocity.AXIS_X,
					(int) angular_velocity.AXIS_Y,
					(int) angular_velocity.AXIS_Z);
			res = f_write(&MyFile, dataOut, size, (void *) &byteswritten);
		}
	}
}

/**
 * @brief  Handles the magneto axes data getting/sending
 * @param  handle the device handle
 * @retval None
 */
void Magneto_Sensor_Handler(void *handle) {
	uint8_t who_am_i;
	float odr;
	float fullScale;
	uint8_t id;
	SensorAxes_t magnetic_field;
	uint8_t status;
	int32_t d1, d2;

	BSP_MAGNETO_Get_Instance(handle, &id);

	BSP_MAGNETO_IsInitialized(handle, &status);

	if (status == 1) {
		if (BSP_MAGNETO_Get_Axes(handle, &magnetic_field) == COMPONENT_ERROR) {
			magnetic_field.AXIS_X = 0;
			magnetic_field.AXIS_Y = 0;
			magnetic_field.AXIS_Z = 0;
		}

		if (SendOverUSB) /* Write data on the USB */
		{
			sprintf(dataOut, "\n\rMAG_X: %d, MAG_Y: %d, MAG_Z: %d",
					(int) magnetic_field.AXIS_X, (int) magnetic_field.AXIS_Y,
					(int) magnetic_field.AXIS_Z);
			CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

			if (verbose == 1) {
				if (BSP_MAGNETO_Get_WhoAmI(handle, &who_am_i)
						== COMPONENT_ERROR) {
					sprintf(dataOut, "WHO AM I address[%d]: ERROR\n", id);
				} else {
					sprintf(dataOut, "WHO AM I address[%d]: 0x%02X\n", id,
							who_am_i);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

				if (BSP_MAGNETO_Get_ODR(handle, &odr) == COMPONENT_ERROR) {
					sprintf(dataOut, "ODR[%d]: ERROR\n", id);
				} else {
					floatToInt(odr, &d1, &d2, 3);
					sprintf(dataOut, "ODR[%d]: %d.%03d Hz\n", (int) id,
							(int) d1, (int) d2);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

				if (BSP_MAGNETO_Get_FS(handle, &fullScale) == COMPONENT_ERROR) {
					sprintf(dataOut, "FS[%d]: ERROR\n", id);
				} else {
					floatToInt(fullScale, &d1, &d2, 3);
					sprintf(dataOut, "FS[%d]: %d.%03d Gauss\n", (int) id,
							(int) d1, (int) d2);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));
			}
		} else if (SD_Log_Enabled) /* Write data to the file on the SDCard */
		{
			uint8_t size;
			size = sprintf(dataOut, "%d\t%d\t%d\t", (int) magnetic_field.AXIS_X,
					(int) magnetic_field.AXIS_Y, (int) magnetic_field.AXIS_Z);
			res = f_write(&MyFile, dataOut, size, (void *) &byteswritten);
		}
	}
}

/**
 * @brief  Handles the humidity data getting/sending
 * @param  handle the device handle
 * @retval None
 */
void Humidity_Sensor_Handler(void *handle) {
	int32_t d1, d2;
	uint8_t who_am_i;
	float odr;
	uint8_t id;
	float humidity;
	uint8_t status;

	BSP_HUMIDITY_Get_Instance(handle, &id);

	BSP_HUMIDITY_IsInitialized(handle, &status);

	if (status == 1) {
		if (BSP_HUMIDITY_Get_Hum(handle, &humidity) == COMPONENT_ERROR) {
			humidity = 0.0f;
		}

		floatToInt(humidity, &d1, &d2, 2);

		if (SendOverUSB) /* Write data on the USB */
		{
			sprintf(dataOut, "\n\rHUM: %d.%02d", (int) d1, (int) d2);
			CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

			if (verbose == 1) {
				if (BSP_HUMIDITY_Get_WhoAmI(handle, &who_am_i)
						== COMPONENT_ERROR) {
					sprintf(dataOut, "WHO AM I address[%d]: ERROR\n", id);
				} else {
					sprintf(dataOut, "WHO AM I address[%d]: 0x%02X\n", id,
							who_am_i);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

				if (BSP_HUMIDITY_Get_ODR(handle, &odr) == COMPONENT_ERROR) {
					sprintf(dataOut, "ODR[%d]: ERROR\n", id);
				} else {
					floatToInt(odr, &d1, &d2, 3);
					sprintf(dataOut, "ODR[%d]: %d.%03d Hz\n", (int) id,
							(int) d1, (int) d2);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));
			}
		} else if (SD_Log_Enabled) /* Write data to the file on the SDCard */
		{
			uint8_t size;
			size = sprintf(dataOut, "%5.2f\t", humidity);
			res = f_write(&MyFile, dataOut, size, (void *) &byteswritten);
		}
	}
}

/**
 * @brief  Handles the temperature data getting/sending
 * @param  handle the device handle
 * @retval None
 */
void Temperature_Sensor_Handler(void *handle) {

	int32_t d1, d2;
	uint8_t who_am_i;
	float odr;
	uint8_t id;
	float temperature;
	uint8_t status;

	BSP_TEMPERATURE_Get_Instance(handle, &id);

	BSP_TEMPERATURE_IsInitialized(handle, &status);

	if (status == 1) {
		if (BSP_TEMPERATURE_Get_Temp(handle, &temperature) == COMPONENT_ERROR) {
			temperature = 0.0f;
		}

		floatToInt(temperature, &d1, &d2, 2);

		if (SendOverUSB) /* Write data on the USB */
		{
			sprintf(dataOut, "\n\rTEMP: %d.%02d", (int) d1, (int) d2);
			CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

			if (verbose == 1) {
				if (BSP_TEMPERATURE_Get_WhoAmI(handle, &who_am_i)
						== COMPONENT_ERROR) {
					sprintf(dataOut, "WHO AM I address[%d]: ERROR\n", id);
				} else {
					sprintf(dataOut, "WHO AM I address[%d]: 0x%02X\n", id,
							who_am_i);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

				if (BSP_TEMPERATURE_Get_ODR(handle, &odr) == COMPONENT_ERROR) {
					sprintf(dataOut, "ODR[%d]: ERROR\n", id);
				} else {
					floatToInt(odr, &d1, &d2, 3);
					sprintf(dataOut, "ODR[%d]: %d.%03d Hz\n", (int) id,
							(int) d1, (int) d2);
				}

				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));
			}
		} else if (SD_Log_Enabled) /* Write data to the file on the SDCard */
		{
			uint8_t size;
			size = sprintf(dataOut, "%3.1f\t", temperature);
			res = f_write(&MyFile, dataOut, size, (void *) &byteswritten);
		}
	}
}

/**
 * @brief  Handles the pressure sensor data getting/sending
 * @param  handle the device handle
 * @retval None
 */
void Pressure_Sensor_Handler(void *handle) {
	int32_t d1, d2;
	uint8_t who_am_i;
	float odr;
	uint8_t id;
	float pressure;
	uint8_t status;

	BSP_PRESSURE_Get_Instance(handle, &id);

	BSP_PRESSURE_IsInitialized(handle, &status);

	if (status == 1) {
		if (BSP_PRESSURE_Get_Press(handle, &pressure) == COMPONENT_ERROR) {
			pressure = 0.0f;
		}

		floatToInt(pressure, &d1, &d2, 2);

		if (SendOverUSB) {
			sprintf(dataOut, "\n\rPRESS: %d.%02d", (int) d1, (int) d2);
			CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

			if (verbose == 1) {
				if (BSP_PRESSURE_Get_WhoAmI(handle, &who_am_i)
						== COMPONENT_ERROR) {
					sprintf(dataOut, "WHO AM I address[%d]: ERROR\n", id);
				} else {
					sprintf(dataOut, "WHO AM I address[%d]: 0x%02X\n", id,
							who_am_i);
				}
				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));

				if (BSP_PRESSURE_Get_ODR(handle, &odr) == COMPONENT_ERROR) {
					sprintf(dataOut, "ODR[%d]: ERROR\n", id);
				} else {
					floatToInt(odr, &d1, &d2, 3);
					sprintf(dataOut, "ODR[%d]: %d.%03d Hz\n", (int) id,
							(int) d1, (int) d2);
				}
				CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));
			}
		} else if (SD_Log_Enabled) /* Write data to the file on the SDCard */
		{
			uint8_t size;
			size = sprintf(dataOut, "%5.2f\t", pressure);
			res = f_write(&MyFile, dataOut, size, (void *) &byteswritten);
		}
	}
}

void Gas_Gauge_Handler(void *handle) {
	uint32_t voltage, soc;
	uint8_t vmode, status;

	BSP_GG_IsInitialized(handle, &status);

	if (status == 1) {
		/* Update Gas Gauge Status */
		if (BSP_GG_Task(handle, &vmode) == COMPONENT_ERROR) {
			voltage = 0.0f;
			soc = 0.0f;
		}

		/* Read the Gas Gauge Status */
		if (BSP_GG_GetVoltage(handle, &voltage) == COMPONENT_ERROR) {
			voltage = 0.0f;
		}

		if (BSP_GG_GetSOC(handle, &soc) == COMPONENT_ERROR) {
			soc = 0.0f;
		}

		if (SendOverUSB) /* Write data on the USB */
		{
			sprintf(dataOut, "\n\rV: %lumV Chrg: %lu%%", (uint32_t) voltage,
					(uint32_t) soc);
			CDC_Fill_Buffer((uint8_t *) dataOut, strlen(dataOut));
		} else if (SD_Log_Enabled) /* Write data to the file on the SDCard */
		{
			uint8_t size;
			size = sprintf(dataOut, "%lu\t%lu\t", (uint32_t) voltage,
					(uint32_t) soc);
			res = f_write(&MyFile, dataOut, size, (void *) &byteswritten);
		}
	}
}

/**
 * @brief  Splits a float into two integer values.
 * @param  in the float value as input
 * @param  out_int the pointer to the integer part as output
 * @param  out_dec the pointer to the decimal part as output
 * @param  dec_prec the decimal precision to be used
 * @retval None
 */
void floatToInt(float in, int32_t *out_int, int32_t *out_dec, int32_t dec_prec) {
	*out_int = (int32_t) in;
	if (in >= 0.0f) {
		in = in - (float) (*out_int);
	} else {
		in = (float) (*out_int) - in;
	}
	*out_dec = (int32_t) trunc(in * pow(10, dec_prec));
}

/**
 * @}
 */

/**
 * @}
 */

/**
 * @}
 */

/**
 * @}
 */

/************************ (C) COPYRIGHT STMicroelectronics *****END OF FILE****/

