// Assignment 10 Problem 1
// Alex Suarez
// swazi
// Hsiu te Lin
// tedlin
// 18 April 2012

import java.util.*;
import colors.*;
import geometry.Posn;
import impsoundworld.*;

/** Represent a <code>Lane</code> of <code>Car</code>s */
public class Lane {
    // The cars in this lane
    ArrayList<Car> cars;
    // The velocity of every car in this lane
    Integer velocity;
    // The y position of every car in this lane
    Integer y;
    Lane(ArrayList<Car> cars, Integer velocity, Integer y) {
        this.cars = cars;
        this.velocity = velocity;
        this.y = y;
        
        // Set every velocity and the position of every care
        // in this lane to the lane's velocity and position
        for (Car c : this.cars) {
           c.velocity = this.velocity;
           c.pos.y = this.y;
        }
    }
    
    
    /** Make the image for this <code>Lane</code> */
    public WorldImage makeLaneImage() {
        // Initialize the base to draw the cars on
        WorldImage base = new RectangleImage(new Posn(0, 0), 0, 0, new White());
        
        // Make the image of all the cars in this lane
        for (Car c : this.cars) {
            c.updateCarImage();
           base = c.image.overlayImages(base);
        }
        
        return base;
    }
    
    
    /** Move all the <code>Car</code>s in this <code>Lane</code> */
    public void moveCars() {
        for (Car c : this.cars) {
            c.move();
        }
    }
    
    
    /** Determine if any car in this <code>Lane</code> hits the given <code>Frog</code> 
     * 
     * @param The <code>Frog</code> we are trying to determine if it has been hit
     */
    public boolean anyRoadKillHuh(Frog f) {
        for (Car c : this.cars) {
            if (f.roadKillHuh(c)) {
                return true;
            }
        }
        return false;
    }

}
