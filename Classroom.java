import java.util.*;
import greenfoot.*;
import java.util.ArrayList;
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
 * Write a description of class Classroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Classroom extends World
{
    private ArrayList<Object> listo = new ArrayList<Object>();
    /**
     * Constructor for objects of class Classroom.
     * 
     */
    public Classroom()
    {    
        // Create a new world with 10x6 cells with a cell size of 130x130 pixels.
        super(10, 6, 130); 

        prepare();
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
   
     private void prepare()
    {
        // Add three lines to this doc with your class constructor and your row and seat number
        // Make sure to match your first and last name to the class file you created.

        /* Example */
        KilgoreTrout kilgoretrout = new KilgoreTrout("Kilgore", "Trout", 1, 1);
        addObject(kilgoretrout, 1, 1);
        kilgoretrout.sitDown();
         
        WangMingye myw = new WangMingye("Mingye", "Wang", 5, 4);
        addObject(myw, 5, 4);
        setPaintOrder(WangMingye.class,staff.class);


    }  
    
    public void act()
    {
        if (WangMingye.staff_load_in)
        {
            staff staff = new staff();
            addObject(staff, 8, 3);
            setPaintOrder(WangMingye.class,staff.class);
            WangMingye.set_staff_status(false);
        }
        if (WangMingye.staff_load_out)
        {
            List remove = getObjects( staff.class );
            for (Object objects : remove) {
                removeObject( ( staff ) objects ); }
            WangMingye.set_staff_status(false);
        }
    }
}
