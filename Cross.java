package Week2.HW2;

import java.awt.Color;

/**
 * A concrete Cross class defined by the location of the upper left points and 
 * its height. Extends AbstractShape. 
 * @author Oscar Morales
 * @version 1/21/15
 */
public class Cross extends AbstractShape
{
    /**
     * A Cross constructor that takes the location of the upper x, upper y, and
     * the height. If the height is not a multiple of 5 then it 
     * throws a IllegalArgumentException. Default color is Green.
     * @param x upper left x
     * @param y upper left y
     * @param height height of Cross
     */
    public Cross(int x, int y, int height)
    {
        super(x,y,height);
        if(height%5!=0)
            throw new IllegalArgumentException("Size must be a multiple of 5.");     
        this.setColor(Color.GREEN);
    }
    
    /**
     * A Cross constructor that takes the location of the upper x, upper y, 
     * the height and the Color. If the height is not a multiple of 5 then it 
     * throws a IllegalArgumentException. 
     * @param x upper left x
     * @param y upper left y
     * @param height height of Cross
     * @param c Color of the Cross
     */
    public Cross(int x, int y, int height,Color c)
    {
        super(x,y,height,c);
        if(height%5!=0)
            throw new IllegalArgumentException("Size must be a multiple of 5.");      
    }
    
    /**
     * A Cross constructor that takes the location of the upper x, upper y, 
     * the height, the Color and if it is selected or not. If the height is not 
     * a multiple of 5 then it throws a IllegalArgumentException. 
     * @param x upper left x
     * @param y upper left y
     * @param height height of Cross
     * @param selected (true) or deselected (false).
     * @param c Color of the Cross
     */
    public Cross(int x, int y, int height,boolean selected,Color c)
    {
        super(x,y,height,selected,c);
        if(height%5!=0)
            throw new IllegalArgumentException("Size must be a multiple of 5.");      
    }
      
    /**
     * This method returns true if the point (x,y) is on the Cross, false if not.
     * This is done by first thinking of the crosses as two rectangles. Each 
     * rectangle would have four points. These points would be 2/5 and 3/5 inside 
     * the box that bounds the Cross. So then we would simply check if our point x and
     * point y would be between our four points of each rectangle. If our point x 
     * and point y lie in either rectangle then our point is on this Cross. If 
     * the point x and y do not lie in any of the rectangles coordinates then it 
     * returns false.
     * @param x point x 
     * @param y point y
     * @return true if the point (x,y) is on the Cross, false if not.
     */ 
    public boolean isOn(int x, int y)
    {
        return  (x>=this.getUpperLeftX() && x<=this.getUpperLeftX()+this.getHeight() 
                && y>=this.getUpperLeftY()+2*this.getHeight()/5 && y<=this.getUpperLeftY()+3*this.getHeight()/5)
                
                
                ||(x>=this.getUpperLeftX()+2*this.getHeight()/5 && x<=this.getUpperLeftX()+3*this.getHeight()/5 
                && y>=this.getUpperLeftY() && y<=this.getUpperLeftY()+this.getHeight());
    }
    
    /**
     * This method provides a String representation of the Cross state.
     * @return a String representation of the Cross
     */
    public String toString()
    {
        return "Cross\n"+super.toString()+"\nHeight: "+this.getHeight();
   
    }

}
