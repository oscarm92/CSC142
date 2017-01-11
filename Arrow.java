package Week2.HW2;

import java.awt.Color;

/**
 * A concrete Arrow class defined by the location of the tip and its height.
 * Extends AbstractShape and defines some new methods. 
 * @author Oscar Morales
 * @version 1/21/15
 */
public class Arrow extends AbstractShape
{
    /**
     * A Arrow constructor that takes the location of the tip x, tip y, 
     * the height and the Color. However this constructor calls the super and uses the 
     * information about the tip and height to initialize the height and upper 
     * left coordinates. The upper left x is found by subtracting the height. The 
     * upper left y is found by subtracting the height and dividing by 2. This 
     * constructor throws a IllegalArgumentException if the the height is not even.
     * Default color is Red.
     * @param xtip the tip x coordinate of the Arrow.
     * @param ytip the tip y coordinate of the Arrow.
     * @param height the height of the Arrow.
     * @throws IllegalArgumentException if the height is not even.
     */
    public Arrow(int xtip, int ytip,int height)
    {
        super(xtip-height,ytip-height/2,height);
        if(height%2!=0)
            throw new IllegalArgumentException("Height must be even number");
        this.setColor(Color.RED);
    }
    
    /**
     * A Arrow constructor that takes the location of the tip x, tip y, 
     * the height and the Color. However this constructor calls the super and uses the 
     * information about the tip and height to initialize the height, upper 
     * left coordinates and the Color is this Arrow. The upper left x is found by
     * subtracting the height. The upper left y is found by subtracting the height
     * and dividing by 2. This constructor throws a IllegalArgumentException if 
     * the the height is not even.
     * @param xtip the tip x coordinate of the Arrow.
     * @param ytip the tip y coordinate of the Arrow.
     * @param height the height of the Arrow.
     * @param c the color of the Arrow.
     * @throws IllegalArgumentException if the height is not even.
     */
    public Arrow(int xtip, int ytip,int height, Color c)
    {
        super(xtip-height,ytip-height/2,height,c);
        if(height%2!=0)
            throw new IllegalArgumentException("Height must be even number");
    }
    
    /**
     * A Arrow constructor that takes the location of the tip x, tip y, 
     * the height and the Color. However this constructor calls the super and uses the 
     * information about the tip and height to initialize the height, upper 
     * left coordinates, the Color is this Arrow and if is Selected or not. 
     * The upper left x is found by subtracting the height. The upper left y is 
     * found by subtracting the height and dividing by 2. This constructor throws 
     * a IllegalArgumentException if the the height is not even.
     * @param xtip the tip x coordinate of the Arrow.
     * @param ytip the tip y coordinate of the Arrow.
     * @param height the height of the Arrow.
     * @param selected selected (true) or deselected (false).
     * @param c the color of the Arrow.
     * @throws IllegalArgumentException if the height is not even.
     */
    public Arrow(int xtip, int ytip,int height,boolean selected,Color c)
    {
        super(xtip-height,ytip-height/2,height,selected,c);
        if(height%2!=0)
            throw new IllegalArgumentException("Height must be even number");
    }
    
    /**
     * This method returns the x tip of this Arrow. It is calculated by adding
     * the upper left x of the Arrow and the height. 
     * @return 
     */
    public int getXTip()
    {
        return this.getUpperLeftX()+this.getHeight();
    }
    
    /**
     * This method returns the y tip of this Arrow. It is calculated by adding
     * the upper left y of the Arrow and the height divided by 2. 
     * @return 
     */
    public int getYTip()
    {
        return this.getUpperLeftY()+this.getHeight()/2;
    }
    
    /**
     * This method returns true if the point (x,y) is on the Arrow, false if not.
     * This is calculated by first determining if the given x point is between
     * the upper left x and the tip x. If it is not then return false. If it is
     * between this point then we determine if the if the point y is between the
     * y value of the top line y1 and the bottom line y2. That is done using the 
     * equation of a line and finding the slope and y intercept. If the y point is
     * between y1 and y2 then it is on the Arrow.
     * @param x point x 
     * @param y point y
     * @return true if the point (x,y) is on the Arrow, false if not.
     */ 
    public boolean isOn(int x, int y)
    {
        if(x>=this.getUpperLeftX() && x<=getXTip())
        {
            int y1=(1*x)/2+(getYTip()-(getXTip()/2));
            int y2=-(1*x)/2+(getYTip()+(getXTip()/2));
            
            return y>=y1 && y<=y2;
        }
        else
            return false;
    }
    
    /**
     * This method provides a String representation of the Arrows state.
     * @return a String representation of the Arrow
     */
    public String toString()
    {
        return "Arrow\n"+super.toString()+"\nHeight: "+this.getHeight()  
                +"\nTip: ("+getXTip()+","+getYTip()+")";
    }
    
}
