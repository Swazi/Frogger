import java.util.*;
import colors.*;
import geometry.Posn;
import impsoundworld.*;

/** The representation of a School of turtles in this game*/
public class School {
    // The turtles in the lane
    ArrayList<Turtle> Turtles;
    // The velocity every turtle in this lane has
    Integer velocity;
    // The y position every turtle in this lane has 
    Integer y;
    School(ArrayList<Turtle> Turtles, Integer velocity, Integer y) {
        this.Turtles = Turtles;
        this.velocity = velocity;
        this.y = y;
        
        
        // Set every velocity and the position of every Turtle
        // in this lane to the School's velocity and position
        for (Turtle c : this.Turtles) {
           c.velocity = this.velocity;
           c.pos.y = this.y;
        }
    }
    
    /** Make the image for this lane */
    public WorldImage makeSchoolImage() {
        // Initialize the base to build the car images on
        WorldImage base = new RectangleImage(new Posn(0, 0), 0, 0, new White());
        
        // Overlay every car image onto the base
        for (Turtle c : this.Turtles) {
            c.updateTurtleImage();
           base = c.image.overlayImages(base);
        }
        
        return base;
    }
    
    /** Move all the turtles in this school */
    public void moveTurtles() {
        for (Turtle c : this.Turtles) {
            c.move();
        }
    }
    
    /** Determine if the given frog is on any turtle in this lane */
    public boolean onAnyTurtle(Frog f) {
        for (Turtle c : this.Turtles) {
            if (f.onTurtleHuh(c)) {
                return true;
            }
        }
        return false;
    }

}
