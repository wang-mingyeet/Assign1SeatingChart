import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class staff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class staff extends Actor
{
    /**
     * Act - do whatever the staff wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation(8,3);
    }    
    public staff()
    {
        setsize();
    }
    public void setsize()
    {
        GreenfootImage img = new GreenfootImage("g-clef.jpg");
        img.scale(img.getWidth() * 2, img.getHeight() * 2);
        setImage(img);
    }
}
