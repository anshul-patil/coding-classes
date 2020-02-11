'''
stamper.py uses a GUI to  create a montage from 
rotated and reduced iterations of an image. 
Rotation, reduction, and iteration are entered by slider.
Rotation direction is entered by a toggling button.
The stamp is initiated by a mouseclick.

version 1 creates the GUI window with the sliders, button, and canvas.
version 2 implements the mouse-click pasting an image
version 3 implements the iterative stamping
ul
'''
from Tkinter import *   # Don't pollute namespace like this except for Tkinter
import PIL    
from PIL import ImageTk # A subpackage that must be imported explicitly
import numpy as np
import os.path              
__dir__ = os.path.dirname(os.path.abspath(__file__))  
filename = os.path.join(__dir__, 'cat1-a.gif')

img = PIL.Image.open(filename)
# The next line isn't needed with the PNG, but is here for later use with JPGs
#imga = img.convert('RGBA') # use alpha so rotate() will fill corners with a=0

root = Tk() # create main window; must be done before using ImageTk

# A slider to set degrees per iteration
rotation = IntVar()
rotSlider = Scale(root,variable=rotation, from_=1, to=30,
                  orient=HORIZONTAL, label='Degrees:')
rotation.set(10)
rotSlider.grid(column=0, row=0, sticky=W)

# A slider to set the number of iterations
iteration = IntVar()
iterSlider = Scale(root,variable=iteration, from_=2, to=15,
                   orient=HORIZONTAL, label='Iterations:')
iteration.set(6)
iterSlider.grid(column=0, row=1, sticky=W)

# A slider to set the resizing factor for each iteration
reduction = DoubleVar()
reduceSlider = Scale(root,variable=reduction, from_=0.5, to=0.99,
                     orient=HORIZONTAL, resolution=.01, label='Reduction:')
reduction.set(.95)
reduceSlider.grid(column=0, row=2, sticky=W)

# A checkbutton to toggle the direction
ccw = IntVar()
direction = Checkbutton(root, variable=ccw,
                        text='Reverse', offvalue=-1) #onvalue=1 by default
ccw.set(1)
direction.grid(column=0, row=3, sticky=W)

# A canvas for mouse events and image drawing
canvas = Canvas(root, height=600, width=600, bg='white')
canvas.grid(column=1, row=0, rowspan=4, sticky=W)
canvas.imglist=[] #to prevent garbage collection

# Stamp function will get bound to the left-mouse-button-down event.
def stamp(event):
    width, height = img.size
    for i in range(iteration.get()):
        
        # Resize
        iterated_img = img.resize( 
                                    ( int(width*reduction.get()**i), 
                                      int(height*reduction.get()**i)
                                    ) # single argument is a 2-tuple
                                 )                
                                 
        # Rotate. Using expand=True prevents cropping
        iterated_img = iterated_img.rotate(i*rotation.get()*ccw.get(),
                                           expand=True) 
        
        # Put alpha channel back in. It was resize that removed it.
        # But it works to put alpha back in here, or between resize and rotate.
        iterated_img = iterated_img.convert('RGBA')
    
        # Cut out the blank edges
        bounds = iterated_img.getbbox() #returns bounding box
        iterated_img = iterated_img.crop(bounds)

        #Convert iterated image to Tk format, hang onto it, and show it
        tkimg = PIL.ImageTk.PhotoImage(iterated_img)
        canvas.imglist += [tkimg] # prevents garbage collection when stamp exits
        canvas.create_image(event.x, event.y, image=tkimg)

# Bind event to handler
canvas.bind('<ButtonPress-1>', stamp)

# The error
#        TclError: image "pyimage nnn" doesn't exist.
# occurs when a previous attempt to run an earlier version has a bug, usually a 
# reference to a filename that doesn't exist or has the wrong directory path.
# Even if you fix the bug and then get this error.
# Any error that prevents a program getting to the event loop will cause
# the buggy program to not show the Tk root window. Once the offending error 
# is fixed, the TclError appears.
# Solution: Run a DIFFERENT working program that calls mainloop(), or comment out 
# the line with the create_image() call.
# The windows all appear,
# can be closed, and then the fixed program can be run without raising TclError.
 
# Enter event loop
root.mainloop() 