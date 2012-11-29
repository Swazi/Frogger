import java.util.*;

import tunes.*;
import impsoundworld.*;
import colors.*;
import geometry.Posn;


/** Represent the Frogger game */
public class Frogger extends World {
    // The static canvas dimensions
    Integer WIDTH = 420;
    Integer HEGHT = 442;
    // The frog in the game
    Frog frog;
    // The lanes of cars in the game
    ArrayList<Lane> lanes;
    // The Schools of turtles in the game
    ArrayList<School> schools;
    // A boolean that determines if the game is paused or not
    Boolean pause;
    // Counters to keep track of the tick count 
    int tickCount;
    Frogger(Frog frog, ArrayList<Lane> lanes, ArrayList<School> schools) {
        this.frog = frog;
        this.lanes = lanes;
        this.schools = schools;
        this.pause = false;
        this.tickCount = 0;
    }
    
    public static int backgroundNotes[] = {
        0,0,0,0,noteC,0,0,0,noteA,0,0,noteF,0,0,noteG,0,0,noteF,0,0,noteD,0,0,0,
        noteUpA,0,0,0,noteG,0,0,noteG,0,0,noteG,0,0,noteF,0,0,0,noteE, 
        noteF,0,0,0, noteG,
    };

    /** Move every <code>Car</code> in the game by moving every <code>Car</code> in each <code>Lane</code> */
    public void moveAllCars() {
        for (Lane l : this.lanes) {
            l.moveCars();
        }
    }

    /** Move ever <code>Turtle</code>in the game by moving every <code>Turtle</code> in each <code>School</code> */
    public void moveAllTurtles() {
        for (School s : this.schools) {
            s.moveTurtles();
        }
    }

    /** Determine if the <code>Frog</code> is in the river 
     * The <code>Frog</code> is in the river if it is below the y position 190 and it is 
     * not on a <code>Turtle</code> or it has made it to the other side */
    public boolean frogInRiverHuh() {
        return(!(this.frog.madeItHuh()) &&
                this.frog.pos.y <= 190 &&
                !this.onAnySchoolHuh());
       }

    

    /** Determine if any of the <code>Car</code>s hit the <code>Frog</code> by checking 
     * if any of the <code>Car</code>s in any <code>Lane</code> hit the <code>Frog</code> */
    public boolean anyRoadKillHuh() {
        for (Lane l : this.lanes) {
            if (l.anyRoadKillHuh(this.frog)) {
                return true;
            }
        }
        return false;
    }
    
    
    /** Determine if this <code>Frog</code> is on any <code>Turtle</code> in this 
     * <code>Frogger</code>'s <code>ArrayList</code> of <code>Schools</code>
     * 
     * @param All of the <code>Turtles</code> in the Frogger game
     */
    public boolean onAnySchoolHuh() {
        for (School s : this.schools ) {
            if (s.onAnyTurtle(this.frog)) {
                return true;
            }
        }
        return false;
    }
    
    /** Determine if the frog has died in any way possible, either hit by a car,
     * run out of time or fallen in the river */
    public boolean isDeadFrog() {
        return this.frogInRiverHuh() ||
                this.anyRoadKillHuh() ||
                this.frog.outOfTimeHuh();
    }


    /** Determine what to do every time the game ticks */
    public void onTick() {
        // If the game is paused then do nothing each tick
        if (this.pause ) {
        } else {


            // If the frog has reached the other side move him to the starting position
            // decrease the initial time by 5 seconds and set his current to the initial time
            if (this.frog.madeItHuh()) {
                this.frog.levelUp();
                this.tickTunes.addNote(PIANO, noteC);
            }

            // Move every car in the game
            this.moveAllCars();

            // Move every turtle in the game
            this.moveAllTurtles();
            
            //  if the frog has died move him to the stating position and
            // reset his time to the initial time
            if (this.isDeadFrog()) {
                this.frog.hit();
                this.tickTunes.addNote(BAGPIPE, noteG);
            }

            // Reduce the frog's current time by .1 since the tick rate is 10
            // times a second
            this.frog.currentTime -= .1;
            
            this.tickTunes.addNote(TUBA, backgroundNotes[this.tickCount]);
            this.tickCount = (this.tickCount + 1) % backgroundNotes.length;
        }
    }

    /** Determine if the world ends */
    public WorldEnd worldEnds() {
        if (this.frog.lives.equals(0)) {
            // The frog is out of lives so the game ends
            return new WorldEnd(true, 
                    this.makeImage()
                    .overlayImages(new TextImage(new Posn(210, 221), "You Died", 50, new Red())));
        } else if (this.frog.wonGameHuh()) {
            // You beat the last level so the game ends
            return new WorldEnd(true, 
                    this.makeImage()
                    .overlayImages(new TextImage(new Posn(210, 221), "You Win!", 50, new Green())));
        } else {
            // Otherwise the game does not end
            return new WorldEnd(false, this.makeImage());
        }
    }


    /** Determine what to do when a key is pressed 
     * 
     * @param The key the user inputs
     */
    public void onKeyEvent(String key) {
        if (this.pause) {
            // If the game is paused the only thing you
            // can do is unpause it
            if (key.equalsIgnoreCase("p")) {
                this.pause = !this.pause;
            }

        } else {
            // Press the p key to pause game
            if (key.equalsIgnoreCase("p")) {
                this.pause = !this.pause;
            }

            // Move the frog according to the key
            this.frog.move(key);
        }
    }
    
    /** Build up the image of all the cars */
    public WorldImage drawAllCars() {
        WorldImage baseCar = new RectangleImage(new Posn(0, 0), 0, 0, new White());
        // Build up the image of all the cars
        for (Lane l : lanes) {
            baseCar = l.makeLaneImage().overlayImages(baseCar);
        }
        return baseCar;
    }

    /** Build up the image of all the turtles */
    public WorldImage drawAllTurtles() {
        WorldImage baseTur = new RectangleImage(new Posn(0, 0), 0, 0, new White());
        // Build up the image of all the turtles
        for (School s : schools) {
            baseTur = s.makeSchoolImage().overlayImages(baseTur);
        }
        return baseTur;
    }
    
    /** Make the image for the Time display */
    public TextImage drawTime() {

        // According to the length of the string representing the time determine where to cut it off
        int cutOff = 1;

        if (this.frog.currentTime.toString().length() >= 4 ) {
            cutOff = 4;
        } else if (this.frog.currentTime.toString().length() >= 3) {
            cutOff = 3;
        }

        // Initialize the time and lives images.
        return new TextImage(new Posn(50, 420), "TIME: " + this.frog.currentTime.toString().substring(0, cutOff), 20, new Red());
    }
    
    /** Make the image for the frog */
    public WorldImage drawFrog() {
        this.frog.updateFrogIMage();
        return this.frog.image;
    }



    public WorldImage makeImage() {
        // Initialize the image of all the cars
        WorldImage Cars = this.drawAllCars();
        // Initialize the image of all the turtles
        WorldImage Turtles = this.drawAllTurtles();
        // Initialize the image of the frog
        WorldImage Frog = this.drawFrog();
        
        // The pause image starts off as an empty string since if the game is not paused
        // it should not be displayed
        TextImage Pause = new TextImage(new Posn(210, 221), "", 20, new Red());

        // Initialize the empty game board
        WorldImage Board = new FromFileImage(new Posn(210, 221), "board.png");

        // Initialize the time and lives images.
        TextImage Time = this.drawTime();
        TextImage Lives = new TextImage(new Posn(380, 420), "LIVES: " + this.frog.lives.toString(), 20, new Red());


        // If the game is paused display the string "PAUSED"!
        if (this.pause) {
            Pause = new TextImage(new Posn(210, 221), "PAUSED!", 50, new Red());

        }

        // Overlay all the images the make up the game
        WorldImage game = Board.overlayImages(Cars.overlayImages(Turtles.overlayImages(Frog.overlayImages(Time.overlayImages(Lives.overlayImages(Pause))))));
        return game;
    }

}
