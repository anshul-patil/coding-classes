'''
stamper.py uses a GUI to  create a montage from 
rotated and reduced iterations of an image. 
Rotation, reduction, and iteration are entered by slider.
Rotation direction is entered by a toggling button.
The stamp is initiated by a mouseclick.

version 1 creates the GUI window with the sliders, button, and canvas.

'''
from Tkinter import * # Don't import like this except for Tkinter
root = Tk() # Create main window

# A slider to set degrees per iteration
rotation = IntVar()
rotSlider = Scale(root,variable=rotation, from_=1, to=30,
                  orient=HORIZONTAL, label='Degrees:')
rotSlider.set(10)
rotSlider.pack()

# A slider to set the number of iterations
iteration = IntVar()
iterSlider = Scale(root,variable=iteration, from_=2, to=15,
                   orient=HORIZONTAL, label='Iterations:')
iterSlider.set(6)
iterSlider.pack()

# A slider to set the resizing factor for each iteration
reduction = DoubleVar()
reduceSlider = Scale(root,variable=reduction, from_=0.5, to=0.99,
                     orient=HORIZONTAL, resolution=.01, label='Reduction:')
reduceSlider.set(.95)
reduceSlider.pack()

# A button to toggle the direction
def reverse():
    # This will need to switch the direction
    pass
direction = Button(root, text='Reverse', command=reverse)
direction.pack()

# A canvas for mouse events and image drawing
canvas = Canvas(root, height=600, width=600, relief=RAISED, bg='white')
canvas.pack()

# Enter event loop
root.mainloop() 