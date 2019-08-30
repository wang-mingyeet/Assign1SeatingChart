import java.util.*;
import greenfoot.*;
import java.util.ArrayList;
import java.lang.Math;
   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Mingye Wang
 * @version 2.0 Aug 13, 2019
 */
public class WangMingye extends Student implements SpecialInterestOrHobby
{
    public String img;
    int[][] location = new int[9][2];
    /**
     * Constructor for the WangMingye class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public WangMingye(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        
        scale(portraitFile, 100, 125);
        sitting=true;
        randLocation();
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public WangMingye() {
        firstName="Mingye";
        lastName="Wang";
        myRow=5;
        mySeat=4;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        
        scale(portraitFile, 100, 125);
        sitting=true;
        randLocation();
    }
     /**
     * Act - do whatever the WangMingye actor needs to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        scale(portraitFile, 100, 125);
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
             sitting = false;
             scale(standingFile, 125, 150);
             
             load_staff();
             
             System.out.println(""); // Print a blank line to create space between any student output.
             getName();
 
             //sayName(soundFile);
            
             myHobby("I like to practice");
            
             // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
             // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
             // Call the sitDown() method to move back  to your seat
             
             circleClass();
             animation();
             load_out_staff();
             
             
             }
            else {
                answerQuestion();
                sitDown();
                scale(portraitFile, 100, 125);
            }
        }
    } 
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");
        
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
        scale(portraitFile, 100, 125);
    }
    /**
     * This is a local method specific to the WangMingye class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        setLocation(2,3);
        Greenfoot.delay(10);
        setLocation(3,3);
        Greenfoot.delay(10);
        setLocation(4,3);
        Greenfoot.delay(10);
        setLocation(5,2);
        Greenfoot.delay(10);
        setLocation(6,3);
        Greenfoot.delay(10);
        setLocation(7,4);
        Greenfoot.delay(10);
        setLocation(2,1);
        Greenfoot.delay(10);
        setLocation(3,5);
        Greenfoot.delay(10);
        setLocation(4,5);
        Greenfoot.delay(10);
        setLocation(5,3);
        Greenfoot.delay(10);
        setLocation(6,4);
        Greenfoot.delay(10);
        setLocation(7,5);
        Greenfoot.delay(10);
        setLocation(2,3);
        Greenfoot.delay(10);
        setLocation(3,3);
        Greenfoot.delay(10);
        setLocation(4,3);
        Greenfoot.delay(10);
        setLocation(5,2);
        Greenfoot.delay(10);
        setLocation(6,3);
        Greenfoot.delay(10);
        setLocation(7,4);
        Greenfoot.delay(10);
        setLocation(3,1);
        Greenfoot.delay(10);
        setLocation(6,5);
        Greenfoot.delay(10);
    }
    public void animation()
    {
        setLocation((int)(10 * Math.random()), (int)(6 * Math.random()));
        scale(standingFile, 400, 500);
        for (int i = 0; i <= 1800; i += 10)
        {
            setRotation(30*i);
            Greenfoot.delay(1);
        }
        scale(standingFile, 125, 150);
        for (int i = 0; i < location.length; i++)
        {
            int j = 0;
            setLocation(location[i][j], location[i][j+1]);
            Greenfoot.delay(1);
        }
        returnToSeat();
    }
    public void myHobby(String s) {
         System.out.println(s);
    }
    /**
    * A local method that constantly updates the size of the image so that it is scaled appropriately
    */
    public void scale(String input, int w, int h)
    {
        GreenfootImage img = new GreenfootImage(input);
        img.scale(w, h);
        setImage(img);
    }
    public void load_staff()
    {
        Classroom classroom = (Classroom) getWorld();
        staff staff = new staff();
        classroom.addObject(staff, 6, 3);
        classroom.setPaintOrder(WangMingye.class,staff.class);
    }
    public void load_out_staff()
    {
        Classroom classroom = (Classroom) getWorld();
        List remove = classroom.getObjects( staff.class );
        for (Object objects : remove) {
                classroom.removeObject( ( staff ) objects ); }
    }
    public void randLocation()
    {
        for (int i = 0; i < location.length; i++)
        {
            for (int j = 0; j < location[i].length; j++)
            {
                location[i][j] = (int)(Math.random() *  255);
            }
        }
        for (int i = 0; i < location.length; i++)
        {
            int j = 0;
            location[i][j] = location[i][j] % 11;
            location[i][j + 1] = location[i][j] % 7;
        }
        for (int i = 0; i < location.length; i++)
        {
            for (int j = 0; j < location[i].length; j++)
            {
                System.out.print(location[i][j] + "   ");
            }
            System.out.print("\n");
        }
    }
}