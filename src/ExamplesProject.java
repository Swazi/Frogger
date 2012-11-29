// Assignment 10 Problem 1
// Alex Suarez
// swazi
// Hsiu te Lin
// tedlin
// 18 April 2012

import tester.Tester;
import tunes.*;
import impsoundworld.*;
import geometry.*;
import java.util.*;
 
 
public class ExamplesProject {
 
    // Frogs
    Frog frog;
    Frog frogHit;
    Frog frogInRiver;
    Frog frogOn;
    Frog frogMadeIt;
    Frog frogWinner;
    Frog frogOutOfTime;
 
    // Cars
    Car car1a;
    Car car1b;
    Car car1c;
    Car car1d;
 
    Car car2a;
    Car car2b;
    Car car2c;
 
    Car car3a;
    Car car3b;
    Car car3c;
 
    Car car4a;
    Car car4b;
    Car car4c;
 
    // Turtles
    Turtle t1a;
    Turtle t1b;
    Turtle t1c;
    Turtle t1d;
    Turtle t1e;
    Turtle t1f;
 
    Turtle t2a;
    Turtle t2b;
    Turtle t2c;
    Turtle t2d;
    Turtle t2e;
    Turtle t2f;
 
    Turtle t3a;
    Turtle t3b;
    Turtle t3c;
    Turtle t3d;
    Turtle t3e;
    Turtle t3f;
 
    Turtle t4a;
    Turtle t4b;
    Turtle t4c;
    Turtle t4d;
    Turtle t4e;
    Turtle t4f;
 
    // ArrayLists of Cars
    ArrayList<Car> ac1;
    ArrayList<Car> ac2;
    ArrayList<Car> ac3;
    ArrayList<Car> ac4;
 
    // ArrayLists of Turtles
    ArrayList<Turtle> at1;
    ArrayList<Turtle> at2;
    ArrayList<Turtle> at3;
    ArrayList<Turtle> at4;
 
    // Lanes
    Lane l1;
    Lane l2;
    Lane l3;
    Lane l4;
 
    // Schools
    School s1;
    School s2;
    School s3;
    School s4;
 
    ArrayList<Lane> al;
    ArrayList<School> as;
 
    Frogger fw;
 
    /** Initialize the starting values for all components of the game and some to test */
    public void initGame() {
 
        // Frogs
        frog = new Frog(new Posn(210, 425), 3, 60);
        frogHit = new Frog(new Posn(40, 282), 3, 60);
        frogInRiver = new Frog(new Posn(420, 150),3, 60);
        frogOn = new Frog(new Posn(40, 152), 3, 60);
        frogMadeIt = new Frog(new Posn(200, 30), 3, 60);
        frogWinner = new Frog(new Posn(30, 30), 3, 5);
        frogOutOfTime = new Frog(new Posn(40, 230), 3, 60);
        frogOutOfTime.currentTime = -0.1;
 
        // Cars
        car1a = new Car(new Posn(40, 282), 1, "car1");
        car1b = new Car(new Posn(150 ,282), 1, "car1");
        car1c = new Car(new Posn(260, 282), 1, "car1");
        car1d = new Car(new Posn(370, 282), 1, "car1");
 
        car2a = new Car(new Posn(40, 306), -2, "car2");
        car2b = new Car(new Posn(180 ,306), -2, "car2");
        car2c = new Car(new Posn(300, 306), -2, "car2");
 
        car3a = new Car(new Posn(40, 340), 3, "car3");
        car3b = new Car(new Posn(180,  340), 3, "car3");
        car3c = new Car(new Posn(300, 340), 3, "car3");
 
        car4a = new Car(new Posn(40, 340), 3, "car4");
        car4b = new Car(new Posn(180,  340), 3, "car4");
        car4c = new Car(new Posn(300, 340), 3, "car4");
 
        // Turtles
        t1a = new Turtle(new Posn(40, 250), -1);
        t1b = new Turtle(new Posn(72, 250), -1);
        t1c = new Turtle(new Posn(104, 250), -1);
        t1d = new Turtle(new Posn(200, 250), -1);
        t1e = new Turtle(new Posn(232, 250), -1);
        t1f = new Turtle(new Posn(264, 250), -1);
 
        t2a = new Turtle(new Posn(40, 250), 1);
        t2b = new Turtle(new Posn(72, 250), 1);
        t2c = new Turtle(new Posn(104, 250), 1);
        t2d = new Turtle(new Posn(200, 250), 1);
        t2e = new Turtle(new Posn(232, 250), 1);
        t2f = new Turtle(new Posn(264, 250), 1);
 
        t3a = new Turtle(new Posn(0, 250), -1);
        t3b = new Turtle(new Posn(32, 250), -1);
        t3c = new Turtle(new Posn(120, 250), -1);
        t3d = new Turtle(new Posn(152, 250), -1);
        t3e = new Turtle(new Posn(240, 250), -1);
        t3f = new Turtle(new Posn(272, 250), -1);
 
        t4a = new Turtle(new Posn(32, 250), 1);
        t4b = new Turtle(new Posn(64, 250), 1);
        t4c = new Turtle(new Posn(96, 250), 1);
        t4d = new Turtle(new Posn(200, 250), 1);
        t4e = new Turtle(new Posn(232, 250), 1);
        t4f = new Turtle(new Posn(264, 250), 1);
 
        // ArrayLists of Cars
        ac1 = new ArrayList<Car>(Arrays.asList(car1a, car1b, car1c, car1d));
        ac2 = new ArrayList<Car>(Arrays.asList(car2a, car2b, car2c));
        ac3 = new ArrayList<Car>(Arrays.asList(car3a, car3b, car3c));
        ac4 = new ArrayList<Car>(Arrays.asList(car4a, car4b, car4c));
 
        // ArrayLists of Turtles
        at1 = new ArrayList<Turtle>(Arrays.asList(t1a, t1b, t1c, t1d, t1e, t1f));
        at2 = new ArrayList<Turtle>(Arrays.asList(t2a, t2b, t2c, t2d, t2e, t2f));
        at3 = new ArrayList<Turtle>(Arrays.asList(t3a, t3b, t3c, t3d, t3e, t3f));
        at4 = new ArrayList<Turtle>(Arrays.asList(t4a, t4b, t4c, t4d, t4e, t4f));
 
        // Lanes
        l1 = new Lane(ac1, 10, 286);
        l2 = new Lane(ac2, -10, 320);
        l3 = new Lane(ac3, -15, 256);
        l4 = new Lane(ac4, 15, 355);
 
        // Schools
        s1 = new School(at1, -5, 185);
        s2 = new School(at2, 5,  152);
        s3 = new School(at3, -10,  120);
        s4 = new School(at4, 8, 84);
 
        al = new ArrayList<Lane>(Arrays.asList(l4, l1, l2, l3));
        as = new ArrayList<School>(Arrays.asList(s1, s2, s3, s4));
 
        fw = new Frogger(frog, al, as);
 
    }
 
    // Test the methods for a Frog
    public void testFrogMethods(Tester t) {
        initGame();
        // Test the roadKillHuh method
        t.checkExpect(frog.roadKillHuh(car1a), false);
        t.checkExpect(frogHit.roadKillHuh(car1a), true);
        // Test the onTurtleHuh method
        t.checkExpect(frogOn.onTurtleHuh(t2a), true);
        t.checkExpect(frog.onTurtleHuh(t2a), false);
        // Test the move method
        frog.move("left");
        t.checkExpect(frog.pos.x, 180);
        t.checkExpect(frog.pos.y, 425);
        frog.move("right");
        t.checkExpect(frog.pos.x, 210);
        t.checkExpect(frog.pos.y, 425);
        frog.move("up");
        t.checkExpect(frog.pos.y, 391);
        t.checkExpect(frog.pos.x, 210);
        frog.move("down");
        t.checkExpect(frog.pos.y, 425);
        t.checkExpect(frog.pos.x, 210);
        // Test the madeitHuh method
        t.checkExpect(frogMadeIt.madeItHuh(), true);
        t.checkExpect(frog.madeItHuh(), false);
        // Test the wonGameHuh method
        t.checkExpect(frogWinner.wonGameHuh(), true);
        t.checkExpect(frog.wonGameHuh(), false);
        // Test the outOfTimeHuh method
        t.checkExpect(frogOutOfTime.outOfTimeHuh(), true);
        t.checkExpect(frog.outOfTimeHuh(), false);
        // Test the hit method
        frogHit.hit();
        t.checkExpect(frogHit.pos.x, 210);
        t.checkExpect(frogHit.pos.y, 425);
        t.checkExpect(frogHit.currentTime, 60.0);
        // Test the levelUp method
        initGame();
        frogMadeIt.levelUp();
        t.checkExpect(frogMadeIt.pos.x, 210);
        t.checkExpect(frogMadeIt.pos.y, 425);
        t.checkExpect(frogMadeIt.time, 55);
        initGame();
    }
    
    /** Test the methods in the class <code>Car</code> */
    public void testCarMethods(Tester t) {
        initGame();
        // Test the constructor for cars
        Car test1 = new Car(new Posn(0,0), 5, "car1");
        Car test2 = new Car(new Posn(-5,0), 5, "car2");
        Car test3 = new Car(new Posn(425,0), 5, "car3");
        Car test4 = new Car(new Posn(0,0), 5, "car4");
        t.checkExpect(test1.height, 24);
        t.checkExpect(test1.length, 28);
        t.checkExpect(test1.image, new FromFileImage(test1.pos, "car1.png"));
        t.checkExpect(test2.height, 24);
        t.checkExpect(test2.length, 28);
        t.checkExpect(test2.image, new FromFileImage(test2.pos, "car2.png"));
        t.checkExpect(test3.height, 26);
        t.checkExpect(test3.length, 24);
        t.checkExpect(test3.image, new FromFileImage(test3.pos, "car3.png"));
        t.checkExpect(test4.height, 24);
        t.checkExpect(test4.length, 25);
        t.checkExpect(test4.image, new FromFileImage(test4.pos, "car4.png"));
        // Test the move method for cars
        test1.move();
        t.checkExpect(test1.pos.x, 5);
        test2.move();
        t.checkExpect(test2.pos.x, 420);
        test3.move();
        t.checkExpect(test3.pos.x, 0);
        initGame();
    }
    
    /** Test the methods for the class <code>Turtle</code> */
    public void testTurtleMethods(Tester t) {
        initGame();
        Turtle test0 = new Turtle(new Posn(0, 0), 5);
        Turtle test1 = new Turtle(new Posn(-5, 0), 5);
        Turtle test2 = new Turtle(new Posn(425, 0), -5);
        // Test the constructor for turtles
        t.checkExpect(test1.image, new FromFileImage(test1.pos, "turtle-right.png"));
        t.checkExpect(test2.image, new FromFileImage(test2.pos, "turtle.png"));
        // Test the move method for turtles
        test0.move();
        t.checkExpect(test0.pos.x, 5);
        test1.move();
        t.checkExpect(test1.pos.x, 420);
        test2.move();
        t.checkExpect(test2.pos.x, 0);
        initGame();
    }
    
    /** Test the methods for the class <code>Lane</code> */
    public void testLaneMethods(Tester t) {
        Car test1 = new Car(new Posn(0,0), 5, "car1");
        Car test2 = new Car(new Posn(-5,0), 5, "car2");
        Car test3 = new Car(new Posn(425,0), 5, "car3");
        Car test4 = new Car(new Posn(0,0), 5, "car4");
        // Test the constructor for lanes
        ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(test1, test2, test3, test4));
        Lane lane1 = new Lane(cars, 10, 200);
        for (Car c : lane1.cars) {
            t.checkExpect(c.pos.y, 200);
            t.checkExpect(c.velocity, 10);
        }
         
        // Test the move all cars method
        lane1.moveCars();
        t.checkExpect(test1.pos.x, 10);
        t.checkExpect(test2.pos.x, 420);
        t.checkExpect(test3.pos.x, 0);
        t.checkExpect(test4.pos.x, 10);
         
        // Test the any road kill method
        Frog testFrog = new Frog(new Posn(10, 200), 3, 60);
        t.checkExpect(lane1.anyRoadKillHuh(testFrog), true);
        t.checkExpect(lane1.anyRoadKillHuh(frog), false);
    }
    
    /** Test the methods for the class <code>School</code> */
    public void testSchoolMethods(Tester t) {
        Turtle test0 = new Turtle(new Posn(0, 0), 5);
        Turtle test1 = new Turtle(new Posn(-5, 0), 5);
        Turtle test2 = new Turtle(new Posn(425, 0), -5);
        // Test the constructor for schools
        ArrayList<Turtle> turtles = new ArrayList<Turtle>(Arrays.asList(test0, test1, test2));
        School school = new School(turtles, 10, 200);
        for (Turtle turt : school.Turtles) {
            t.checkExpect(turt.pos.y, 200);
            t.checkExpect(turt.velocity, 10);
        }
         
        // Test the moveTurtles method for schools
        school.moveTurtles();
        t.checkExpect(test0.pos.x, 10);
        t.checkExpect(test1.pos.x, 420);
        t.checkExpect(test2.pos.x, 0);
    }
    
    /** Test the methods for <code>Frogger</code> */
    
    // Test the moveAllCars method for frogger
    public void testMoveAllCars(Tester t) {
        initGame();
        fw.moveAllCars();
        t.checkExpect(car1a.pos.x, 50);
        t.checkExpect(car1b.pos.x, 160);
        t.checkExpect(car1c.pos.x, 270);
        t.checkExpect(car1d.pos.x, 380);
        t.checkExpect(car2a.pos.x, 30);
        t.checkExpect(car2b.pos.x, 170);
        t.checkExpect(car2c.pos.x, 290);
        t.checkExpect(car3a.pos.x, 25);
        t.checkExpect(car3b.pos.x, 165);
        t.checkExpect(car3c.pos.x, 285);
        t.checkExpect(car4a.pos.x, 55);
        t.checkExpect(car4b.pos.x, 195);
        t.checkExpect(car4c.pos.x, 315);
        initGame();
    }
    
    // Test the moveAllTurtles method for frogger
    public void testMoveAllTurtles(Tester t) {
        initGame();
        fw.moveAllTurtles();
        t.checkExpect(t1b.pos.x, 67);
        t.checkExpect(t1c.pos.x, 99);
        t.checkExpect(t1d.pos.x, 195);
        t.checkExpect(t1e.pos.x, 227);
        t.checkExpect(t1f.pos.x, 259);
        t.checkExpect(t2a.pos.x, 45);
        t.checkExpect(t2b.pos.x, 77);
        t.checkExpect(t2c.pos.x, 109);
        t.checkExpect(t2d.pos.x, 205);
        t.checkExpect(t2e.pos.x, 237);
        t.checkExpect(t2f.pos.x, 269);
        t.checkExpect(t3a.pos.x, -10);
        t.checkExpect(t3b.pos.x, 22);
        t.checkExpect(t3c.pos.x, 110);
        t.checkExpect(t3d.pos.x, 142);
        t.checkExpect(t3e.pos.x, 230);
        t.checkExpect(t3f.pos.x, 262);
        t.checkExpect(t4a.pos.x, 40);
        t.checkExpect(t4b.pos.x, 72);
        t.checkExpect(t4c.pos.x, 104);
        t.checkExpect(t4d.pos.x, 208);
        t.checkExpect(t4e.pos.x, 240);
        t.checkExpect(t4f.pos.x, 272);
        initGame();
        }
    
    // test the frogInRiverHuh method for frogger
    public void testFrogInRiverHUh(Tester t) {
        initGame();
        Frogger testWorld = new Frogger(frogInRiver, this.al, this.as);
        t.checkExpect(testWorld.frogInRiverHuh(), true);
        t.checkExpect(fw.frogInRiverHuh(), false);
        initGame();
    }
    
    // test the anyRoadKillHuh method for frogger
    public void testAnyRoadKillHuh(Tester t) {
        initGame();
        Frogger testWorld = new Frogger(frogHit, this.al, this.as);
        t.checkExpect(testWorld.anyRoadKillHuh(), true);
        t.checkExpect(fw.anyRoadKillHuh(), false);
        initGame();
    }
    
    // test on key
    public void testOnKey(Tester t) {
        initGame();
        Frog initialFrog = frog;
        Frogger frogger = new Frogger(frog, al, as);
        // Test the moving part of the on key method
        frogger.onKeyEvent("UP");
        initialFrog.move("UP");
        t.checkExpect(frogger.frog, initialFrog);
        frogger.onKeyEvent("DOWN");
        initialFrog.move("DOWN");
        t.checkExpect(frogger.frog, initialFrog);
        frogger.onKeyEvent("LEFT");
        initialFrog.move("LEFT");
        t.checkExpect(frogger.frog, initialFrog);
        frogger.onKeyEvent("RIGHT");
        initialFrog.move("RIGHT");
        t.checkExpect(frogger.frog, initialFrog);
        // Now pause the games
        frogger.onKeyEvent("P");
        t.checkExpect(frogger.pause, true);
        frogger.onKeyEvent("UP");
        t.checkExpect(frogger.frog, initialFrog);
        frogger.onKeyEvent("DOWN");
        t.checkExpect(frogger.frog, initialFrog);
        frogger.onKeyEvent("LEFT");
        t.checkExpect(frogger.frog, initialFrog);
        frogger.onKeyEvent("RIGHT");
        t.checkExpect(frogger.frog, initialFrog);
        frogger.onKeyEvent("P");
        t.checkExpect(frogger.pause, false);
        
    }
    
    // test on tick
    public void testOnTick(Tester t) {
        initGame();
        Frogger initial = new Frogger(frog, al, as);
        Frogger paused = new Frogger(frog, al, as);
        Frogger inRiver = new Frogger(frogInRiver, al, as);
        Frogger outOfTime = new Frogger(frogOutOfTime, al, as);
        Frogger tuneTester = new Frogger(frog, al, as);
        Frogger hitByCar = new Frogger(new Frog(new Posn(85, 360), 3, 60), al, as);
        // When a pause world ticks nothing should change
        paused.pause = true;
        paused.onTick();
        t.checkExpect(initial.frog, paused.frog);
        t.checkExpect(initial.lanes, paused.lanes);
        t.checkExpect(initial.schools, paused.schools);
        // The frog in this world is in the river so make sure onTick
        // acts accordingly
        initGame();
        // Mimic what should happen on tick with a dead frog
        initial.frog.hit();
        initial.frog.currentTime -= .1;
        initial.moveAllCars();
        initial.moveAllTurtles();
        t.checkExpect(inRiver.isDeadFrog(), true);
        inRiver.onTick();
        t.checkExpect(inRiver.lanes, initial.lanes);
        t.checkExpect(inRiver.schools, initial.schools);
        t.checkExpect(inRiver.frog.isSameFrog(initial.frog));
        // The frog in this world has been hit by a car so make sure it
        // acts accordingly
        t.checkExpect(hitByCar.isDeadFrog(), true);
        hitByCar.onTick();
        t.checkExpect(hitByCar.lanes, initial.lanes);
        t.checkExpect(hitByCar.schools, initial.schools);
        t.checkExpect(hitByCar.frog.isSameFrog(initial.frog));
        // The frog in this world is out of time make sure on tick acts
        // accordingly
        t.checkExpect(outOfTime.isDeadFrog(), true);
        outOfTime.onTick();
        t.checkExpect(outOfTime.lanes, initial.lanes);
        t.checkExpect(outOfTime.schools, initial.schools);
        t.checkExpect(outOfTime.frog.pos, initial.frog.pos);
        // Test the tunes part of the on tick method
        t.checkExpect(tuneTester.tickCount, 0);
        tuneTester.onTick();
        t.checkExpect(tuneTester.tickCount, 1);
        initial.tickTunes.addNote(initial.TUBA, initial.backgroundNotes[0]);
        t.checkExpect(tuneTester.tickTunes, initial.tickTunes);
        initGame();
        
       
        
    }
 
    public static void main(String[] argv){
        ExamplesProject fw = new ExamplesProject();
        fw.initGame();
        Frogger frogger = new Frogger(fw.frog, fw.al, fw.as);
 
        frogger.bigBang(420, 442, 0.1);
    }
} 