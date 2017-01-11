package Week2.HW2;

import java.awt.Color;

/**
 * An abstract class that implements interface Shape with some default implementations
 * and a abstract method. Shapes all have an upper left x and an upper left y. As
 * well as a height color and if the Shape is selected. 
 * @author Oscar Morales
 * @version 1/21/15
 */
public abstract class AbstractShape implements Shape
{
    private int upperLeftX; //upper left X coordinate of the bounding box.
    private int upperLeftY; //upper left Y coordinate of the bounding box.
    private int height; //height of the bounding box.
    private boolean selected; //selected (true) or deselected (false).
    private Color c; //color of the Shape.
    
    /**
     * A constructor that takes the upper left X coordinate of the bounding box,
     * upper left Y coordinate of the bounding box, and the height of the bounding 
     * box.
     * @param x upper left X coordinate of the bounding box.
     * @param y upper left Y coordinate of the bounding box.
     * @param height height of the bounding box.
     */
    public AbstractShape(int x, int y, int height)
    {
        if(height<0)
            throw new IllegalArgumentException("Cannot create Shape with negative height.");
        this.upperLeftX=x;
        this.upperLeftY=y;
        this.height=height;
        this.setSelected(false);
        this.c=new Color(0,0,0);
    }
    
    /**
     * A constructor that takes the upper left X coordinate of the bounding box,
     * upper left Y coordinate of the bounding box, the height of the bounding 
     * box, and the color of the Shape.
     * @param x upper left X coordinate of the bounding box.
     * @param y upper left Y coordinate of the bounding box.
     * @param height height of the bounding box.
     * @param c color of the Shape.
     */
    public AbstractShape(int x, int y, int height, Color c)
    {
        this.upperLeftX=x;
        this.upperLeftY=y;
        this.height=height;
        this.setSelected(false);
        this.c=c;
    }
    
    /**
     * A constructor that takes the upper left X coordinate of the bounding box,
     * upper left Y coordinate of the bounding box, the height of the bounding 
     * box, the color of the Shape, and selected (true) or deselected (false).
     * @param x upper left X coordinate of the bounding box.
     * @param y upper left Y coordinate of the bounding box.
     * @param height height of the bounding box.
     * @param selected selected (true) or deselected (false).
     * @param c color of the Shape.
     */
    public AbstractShape(int x, int y, int height, boolean selected, Color c)
    {
        this.upperLeftX=x;
        this.upperLeftY=y;
        this.height=height;
        this.setSelected(selected);
        this.c=c;
    }
    
     /**
     * This method returns true if the point (x,y) is on the Shape, false if not.
     * @param x point x 
     * @param y point y
     * @return true if the point (x,y) is on the Shape, false if not.
     */ 
    public abstract boolean isOn(int x, int y);
    
    /**
     * This method returns true if this Shape is selected, false if not.
     * @return true if this Shape is selected, false if not.
     */
    public boolean isSelected()
    {
        return selected;
    }
    
    /**
     * This method sets this Shape to be selected (true) or deselected (false). 
     * @param b selected (true) or deselected (false)
     */
    public void setSelected(boolean b)
    {
        this.selected=b;
    }
    
    /**
     * This method sets the color of this shape to c.
     * @param c sets the color of this shape
     */
    public void setColor(Color c)
    {
        this.c=c;
    }
    
    /**
     * This method gets the color of this shape. 
     * @return the color of this shape
     */
    public Color getColor()
    {
        return c;
    }
    
    /**
     * This method moves the upper-left corner of of the "bounding box" of this 
     * Shape deltaX units along the x-axis and deltaY units along the y-axis.
     * @param deltaX units moved along the x-axis
     * @param deltaY units moved along the y-axis
     */
    public void shiftUpperLeftBy(int deltaX, int deltaY)
    {
        this.upperLeftX+=deltaX;
        this.upperLeftY+=deltaY;
    }
    
    /**
     * This method moves the upper-left corner of of the "bounding box" of this 
     * Shape to the new location.
     * @param newX new x location
     * @param newY new y location
     */
    public void moveUpperLeftTo(int newX, int newY)
    {
        this.upperLeftX=newX;
        this.upperLeftY=newY;
    }
    
    /**
     * This method provides a String representation of the Shapes state.
     * @return a String representation of the Shape
     */
    public String toString()
    {
        return "Upper left: ("+upperLeftX+","+upperLeftY+").";
    }
    
    /**
     * This method gets the upper left X coordinate of the bounding box.
     * @return upper left X coordinate
     */
    public int getUpperLeftX()
    {
        return upperLeftX;
    }
    
    /**
     * This method gets the upper left Y coordinate of the bounding box.
     * @return upper left Y coordinate
     */
    public int getUpperLeftY()
    {
        return upperLeftY;
    }
    
    /**
     * This method returns the height of the box inclosing the shape.
     * @return height of the box inclosing the shape
     */
    public int getHeight()
    {
        return height;
    }
    
    
}
