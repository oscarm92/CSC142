package Week2.HW2;

import java.awt.Color;

/**
 * The interface of a shape. A few methods are named here that will be used by all
 * shapes implementing this class.
 * @author Oscar Morales
 * @version 1/21/15
 */
public interface Shape 
{
    /**
     * This method returns true if the point (x,y) is on the Shape, false if not.
     * @param x point x 
     * @param y point y
     * @return true if the point (x,y) is on the Shape, false if not.
     */
    public boolean isOn(int x, int y);
    
    /**
     * This method returns true if this Shape is selected, false if not.
     * @return true if this Shape is selected, false if not.
     */
    public boolean isSelected();
    
    /**
     * This method sets this Shape to be selected (true) or deselected (false). 
     * @param b selected (true) or deselected (false)
     */
    public void setSelected(boolean b);
    
    /**
     * This method sets the color of this shape to c.
     * @param c sets the color of this shape
     */
    public void setColor(Color c);
    
    /**
     * This method gets the color of this shape. 
     * @return the color of this shape
     */
    public Color getColor();
    
    /**
     * This method moves the upper-left corner of of the "bounding box" of this 
     * Shape deltaX units along the x-axis and deltaY units along the y-axis.
     * @param deltaX units moved along the x-axis
     * @param deltaY units moved along the y-axis
     */
    public void shiftUpperLeftBy(int deltaX, int deltaY);
    
    /**
     * This method moves the upper-left corner of of the "bounding box" of this 
     * Shape to the new location.
     * @param newX new x location
     * @param newY new y location
     */
    public void moveUpperLeftTo(int newX, int newY);
    
    /**
     * This method gets the upper left X coordinate of the bounding box.
     * @return upper left X coordinate
     */
    public int getUpperLeftX();
    
    /**
     * This method gets the upper left Y coordinate of the bounding box.
     * @return upper left Y coordinate
     */
    public int getUpperLeftY();    
    
    /**
     * This method returns the height of the box inclosing the shape.
     * @return height of the box inclosing the shape
     */
    public int getHeight();
                
    /**
     * This method provides a String representation of the Shapes state.
     * @return a String representation
     */
    public String toString();
    
    
}
