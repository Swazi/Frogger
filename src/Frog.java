import impsoundworld.*;
import java.util.*;
import geometry.*;

/** Represent the frog in Frogger */
public class Frog {
    // The position of the frog
    Posn pos;
    // The number of lives it has left
    Integer lives;
    // The image that represents the frog
    WorldImage image;
    // The initial time the frog has to reach the other side
    Integer time;
    // The current time the frog has to reach the other side
    Double currentTime;
    Frog(Posn pos, Integer lives, Integer time) {
        this.pos = pos;
        this.lives = lives;
        this.image = new FromFileImage(this.pos, "frog.png");
        this.time = time;
        this.currentTime = time * 1.0;
    }
    
    /** Determine if two frogs are structurally the same for
     * testing purposes */
    public boolean isSameFrog(Frog f) {
        return  this.pos.x == f.pos.x &&
                this.pos.y == f.pos.y &&
                this.time.equals(f.time)  &&
                this.currentTime.equals(f.currentTime);
    }

    /** Determine if this <code>Frog</code> is hit by the given car
     * 
     * @param The <code>Car<code> we are trying to determine if it hit this <code>Frog<coe> 
     */
    public boolean roadKillHuh(Car c) {
        // Determine the edges of the frog and the car based on the 
        // position and dimensions
        int carRightEdge = c.pos.x + c.length/2;
        int carLeftEdge = c.pos.x - c.length/2;
        int carTop = c.pos.y - c.height/2;
        int carBot = c.pos.y + c.height/2;
        int frogLeftEdge = this.pos.x  - 21/2;
        int frogRightEdge = this.pos.x + 21/2;
        int frogTop = this.pos.y - 25/2;
        int frogBot = this.pos.y + 25/2;


        // There are four cases where a frog is hit by the car, check them all
        if (frogLeftEdge < carRightEdge
                && frogLeftEdge > carLeftEdge 
                && frogTop < carBot
                && frogTop > carTop){
            return true;
        } else if (frogLeftEdge < carRightEdge
                && frogLeftEdge > carLeftEdge 
                && frogBot > carTop
                && frogBot < carBot){
            return true;    
        } else if (frogRightEdge > carLeftEdge
                && frogRightEdge < carRightEdge
                && frogTop < carBot
                && frogTop > carTop){
            return true;
        } else if (frogRightEdge > carLeftEdge
                && frogRightEdge < carRightEdge
                && frogTop > carTop
                && frogTop < carTop){
            return true;
        } else {
            return false;
        }

    }

    /** Determine if the <code>Frog</code> is on the given <code>Turtle</code>
     * 
     * @param The <code>Turtle</code> we are trying to determine if the frog is on
     */ 
    public boolean onTurtleHuh(Turtle t) {
        // It is much easier to see if a frog is on a turtle 
        // because a turtle can be represented as a circle
        return this.pos.x <= t.pos.x + t.radius &&
                this.pos.y <= t.pos.y + t.radius &&
                this.pos.x >= t.pos.x - t.radius &&
                this.pos.y >= t.pos.y - t.radius;
    }


    /** Move the frog in this given direction as long it will not move him of the screen 
     * According to the given string
     * 
     * @param The direction to move the <code>Frog</code>
     */
    public void move(String direction) {
        // Determine if moving in this direction will cause the frog to move off the screen
        if (this.pos.x <= 15 &&
                direction.equalsIgnoreCase("left")) {
        } else if (this.pos.x >= 395 &&
                direction.equalsIgnoreCase("right")) {
        } else if (this.pos.y >= 415 && 
                direction.equalsIgnoreCase("down")) {

            // Move the frog
        } else if (direction.equalsIgnoreCase("left")) {
            this.pos.x -= 30;
        } else if (direction.equalsIgnoreCase("right")) {
            this.pos.x += 30;
        } else if (direction.equalsIgnoreCase("up")) {
            this.pos.y -= 34;
        } else if (direction.equalsIgnoreCase("down")) {
            this.pos.y += 34;
        }
    }


    /** Determine if the <code>Frog</code> has made it to the other side */
    public boolean madeItHuh() {
        if (this.pos.y <= 60 
                && ((this.pos.x >= 19 && this.pos.x <= 51)
                        || (this.pos.x >= 104 && this.pos.x <= 143)
                        || (this.pos.x >= 192 && this.pos.x <= 226)
                        || (this.pos.x >= 275 && this.pos.x <= 312)
                        || (this.pos.x >= 362 && this.pos.x <= 400))) {
            return true;
        } else {
            return false;
        }
    }

    /** Determine if the player has won the game by beating a level in under 10 seconds*/
    public boolean wonGameHuh() {
        if (this.time < 10) {
            return true;
        } else {
            return false;
        }
    }

    /** Determine if the <code>Frog</code> is out of time */
    public boolean outOfTimeHuh() {
        if (this.currentTime <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /** The <code>Frog</code> has been hit! 
     * Reset the time, reduce the lives by one and move it to the starting position
     */
    public void hit() {
        this.lives--;
        this.pos.x = 210;
        this.pos.y = 425;
        this.currentTime = this.time * 1.0; 
    }
    
    /** Increase the level of the game by decreasing the initial time by 5 and reseting the position and current time */ 
    public void levelUp() {
        this.pos.y = 425;
        this.pos.x = 210;
        this.time -= 5;
        this.currentTime = this.time * 1.0; 
    }
   

    /** Update the <code>Frog</code>'s image */
    public void updateFrogIMage() {
        this.image.pinhole = this.pos;
    }
}
