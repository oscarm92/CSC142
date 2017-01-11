package Week2.HW2;

import java.awt.Color;

/**
 * A concrete Circle class defined by the location of the center and the radius.
 * Extends AbstractShape and defines some new methods. 
 * @author Oscar Morales
 * @version 1/21/15
 */
public class Circle extends AbstractShape 
{
    /**
     * A Circle constructor that takes the location of the center x, center y, 
     * and the radius r. However this constructor calls the super and uses the 
     * information about the center and radius to initialize the height and upper 
     * left coordinates. The upper left x and y is center x center y minus the radius.
     * Default color is Yellow.
     * @param centerX the center x of the circle.
     * @param centerY the center y of the circle.
     * @param r the radius of the circle.
     */
    public Circle(int centerX,int centerY,int r)
    {
        super(centerX-r,centerY-r,2*r);
        this.setColor(Color.YELLOW);
    }
    
    /**
     * A Circle constructor that takes the location of the center x, center y, 
     * the radius r, and the Color c. However this constructor calls the super
     * and uses the information about the center and radius to initialize the 
     * height and upper left coordinates. The upper left x and y is center x 
     * center y minus the radius.
     * @param centerX the center x of the circle.
     * @param centerY the center y of the circle.
     * @param r the radius of the circle.
     * @param c the color of the circle.
     */
    public Circle(int centerX,int centerY,int r,Color c)
    {
        super(centerX-r,centerY-r,2*r,c);
    }
    
    /**
     * A Circle constructor that takes the location of the center x, center y, 
     * the radius r, the Color c and if the Circle is selected. However this 
     * constructor calls the super and uses the information about the center and 
     * radius to initialize the height and upper left coordinates. The upper left 
     * x and y is center x center y minus the radius.
     * @param centerX the center x of the circle.
     * @param centerY the center y of the circle.
     * @param r the radius of the circle.
     * @param selected selected (true) or deselected (false).
     * @param c the color of the circle.
     */
    public Circle(int centerX,int centerY,int r, boolean selected, Color c)
    {
        super(centerX-r,centerY-r,2*r,selected,c);
    }
    
    /**
     * A method to get the radius of this circle. The radius is the height of 
     * the circle divided by 2.
     * @return radius of this circle
     */
    public int getRadius()
    {
        return this.getHeight()/2;
    }
    
    /**
     * A method to get the center X of this circle. The center x is the upper
     * left x plus the radius of this circle. 
     * @return the center X of this circle
     */
    public int getCenterX()
    {
        return this.getUpperLeftX()+this.getRadius();
    }
    
    /**
     * A method to get the center Y of this circle. The center y is the upper
     * left y plus the radius of this circle. 
     * @return the center X of this circle
     */
    public int getCenterY()
    {
        return this.getUpperLeftY()+this.getRadius();
    }
    
    /**
     * This method returns true if the point (x,y) is on the Circle, false if not.
     * It is calculated by finding the distance from the center of the Circle to 
     * the given point. If the distance is further than the radius of the Circle
     * then the point in not on the Circle. If the distance is less than or equal 
     * to the point then it is on the Circle. 
     * @param x point x 
     * @param y point y
     * @return true if the point (x,y) is on the Circle, false if not.
     */ 
    public boolean isOn(int x, int y)
    {
        return Math.sqrt(Math.pow(getCenterX()-x, 2)+Math.pow(getCenterY()-y, 2)) <= this.getRadius();                  
    }
    
    /**
     * This method provides a String representation of the Circles state.
     * @return a String representation of this Circle
     */
    public String toString()
    {
        return "Circle\n"+super.toString()+"\nCenter: "+"("+getCenterX()+","+getCenterY()+").\nRadius: "+getRadius()+".";
    }
    
           
}
