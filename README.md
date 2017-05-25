# Board

Board allows you to create a billing board and to use command-line operators to draw geometric figures.

# Features:
- Build a Canvas representing a Billing Board
- Draw horizontal and vertical lines
- Draw rectangles
- Paint with bucket starting from a point and choosing a color

# Build 
The project makes use of maven, so a simple `mvn clean install` will do the trick.

# Design choices
The possible elements to be drawn in the billing board must implement the `Drawable` interface.
This will make sure they will fit in the architecture box, while maintaing Composition over Inheritance paradigm.
This is done in order to make it easy to code new geometric figures, just implement the interface!

All the classes and methods are designed to maintaint dipendencies to the minimum, so to improve junit testable factor and 
relax the design in order to be able to expand the application with minimum headache.

# Billing Board convention
The billing board coordinate system is depicted as follows
```
     X 1:N 
     --------------------
 Y  |                    |
 1  |                    |
 :  |                    |
 M  |                    |
    |                    |
    |                    |
     --------------------
```
