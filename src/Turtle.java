// Assignment 10 Problem 1
// Alex Suarez
// swazi
// Hsiu te Lin
// tedlin
// 18 April 2012

import impsoundworld.*;
import geometry.*;

/** The representation of a Turtle in the Frogger game */
public class Turtle {
    // The position of the turtle
    Posn pos;
    // The radius of this turtle
    Integer radius;
    // The image that represents the turtle
    WorldImage image;
    // The velocity of the turtle
    Integer velocity;
    Turtle(Posn pos, Integer velocity) {
        this.pos = pos;
        this.velocity = velocity;
        
        // Determine which image to use for the turtle
        if (this.velocity > 0) {
            this.image = new FromFileImage(this.pos, "turtle-right.png");
        } else {
            this.image = new FromFileImage(this.pos, "turtle.png");
        }
        
        this.radius = 17;
    }
    
    /** Move the turtle, If it is going to move off screen just switch it
     * to the other side of the screen*/
    public void move() {
        if (this.pos.x < 0) {
            this.pos.x = 420;
        } else if (this.pos.x > 420) {
            this.pos.x = 0;
        } else {
            this.pos.x += this.velocity;
        }
    }
    
    
    /** Update this turtle's image */
    public void updateTurtleImage() {
        this.image.pinhole = this.pos;
    }

}
    
    


