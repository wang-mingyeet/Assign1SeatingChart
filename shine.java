import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shine extends Actor
{
    /**
     * Act - do whatever the shine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ;
    }   
    public shine()
    {
        setsize();
    }
    public void setsize()
    {
        GreenfootImage img = new GreenfootImage("shine.jpg");
        img.scale(img.getWidth() / 7, img.getHeight() / 7);
        setImage(img);
    }
}
