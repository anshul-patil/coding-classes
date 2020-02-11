import matplotlib.pyplot as plt
import os.path
import numpy as np # "as" lets us use standard abbreviations
'''Read the image data'''
# Get the directory of this python script
directory = os.path.dirname(os.path.abspath(__file__))
# Build an absolute filename from directory + filename
filename = os.path.join(directory, 'woman.jpg')
# Read the image data into an array
img = plt.imread(filename)
'''Show the image data'''
# Create figure with 1 subplot
fig, ax = plt.subplots(1, 2)
# Show the image data in a subplot
ax[0].imshow(img, interpolation='none')
ax[1].imshow(img, interpolation='none')
# Show the figure on the screen
###
# Make a rectangle of pixels yellow
###
height = len(img)
width = len(img[0])
for row in range(200, 280):
    for column in range(50, 400):
        img[row][column] = [255, 255, 0] #
fig.show()
