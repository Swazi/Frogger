// Assignment 10 Problem 1
// Alex Suarez
// swazi
// Hsiu te Lin
// tedlin
// 18 April 2012

import impsoundworld.*;
import geometry.*;

/** The representation of a car in the Frogger game */
public class Car {
    // The car's position
    Posn pos;
    // The car's dimensions
    Integer length;
    Integer height;
    // The image that represents this car
    WorldImage image;
    // The cars velocity
    Integer velocity;
    // Which type of car this is
    String type;
    Car(Posn pos, Integer velocity, String type) {
        this.pos = pos;
        this.type = type;

        // Set the car's image and dimensions according to the type of car it is
        if (this.type.equalsIgnoreCase("car1")) {
            this.image = new FromFileImage(this.pos, "car1.png");
            this.length = 28;
            this.height = 24;
        } else if (this.type.equalsIgnoreCase("car2")) {
            this.image = new FromFileImage(this.pos, "car2.png");
            this.length = 28;
            this.height = 24;
        } else if (this.type.equalsIgnoreCase("car3")){
            this.image = new FromFileImage(this.pos, "car3.png");
            this.length = 24;
            this.height = 26;
        } else {
            this.image = new FromFileImage(this.pos, "car4.png");
            this.length = 25;
            this.height = 24;
        }

        this.velocity = velocity;
    }

    /** Move this car according to it's given velocity, 
     * if it moves off screen then switch it to the other side*/
    public void move() {
        if (this.pos.x < 0) {
            this.pos.x = 420;
        } else if (this.pos.x > 420) {
            this.pos.x = 0;
        } else {
            this.pos.x += this.velocity;
        }
    }

    /** Update where the car's image should be */
    public void updateCarImage() {
        this.image.pinhole = this.pos;
    }

}
