package Week2.HW2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A method to show a graphical representation of the drawing board. 
 * @author Oscar Morales
 * @version 1/31/15
 */
public class GraphicView extends JPanel implements DrawingBoardListener
{
    private DrawingBoard db;
    private Shape tempShape=null;
    
    /**
     * Constructs a GraphicView object that also displays a quick message to the
     * user. 
     * @param db 
     */
    public GraphicView(DrawingBoard db)
    {
        super( );
        this.setPreferredSize( new Dimension( 500, 500 ) );
        this.db=db;
        db.addListener(this);
        JOptionPane.showMessageDialog(this,"Hello Welcome to my Graphics Editor App. Just a reminder before we begin. \n"
                + "Click the buttons to draw a Shape. You can also specify the size of the Shape by dragging it\n"
                + "when you have clicked on the button to draw a Shape. When you are done drawing make sure to click on the\n"
                + "Stop drawing button. You can also press R on the key board to remove a Shape and C to clear the board.");
        this.setBackground(Color.BLACK);
    }
    
    /**
     * Repaints the drawing board. 
     */
    public void drawingBoardChanged() 
    {
        this.repaint();
    }
    
    /**
     * Repaint the simulation by requesting each item to repaint itself
     * @param g the graphics context where the painting should take place
     */
    public void paintComponent( Graphics g ) 
    {
        super.paintComponent( g ); 
        
        for(int i=0; i<db.getSize(); i++)
        {
            Shape s = db.getShapeAtIndex(i);
            drawShape(g,s);
        }  
        if(tempShape!=null)
        {
            drawShape(g,tempShape);
            repaint();
        }
    }
    
    /**
     * A method to set the temp Shape for when we are drawing the Shape while 
     * dragging.
     * @param s Shape 
     */
    public void setTempShape(Shape s)
    {
        tempShape =s ;
        repaint();
    }
    
    /**
    * Draw graphical representation of this Cross.
    * @param g Graphics context where the drawing should occur
    */
    public void drawArrow(Graphics g,Arrow s)
    {
        if(s.isSelected())
        {
            g.setColor(Color.BLACK);
            g.drawRect(s.getUpperLeftX(), s.getUpperLeftY(), s.getHeight(), s.getHeight());
        }
        g.setColor(s.getColor());
        Polygon Arrow = new Polygon( );
        Arrow.addPoint( s.getUpperLeftX(), s.getUpperLeftY());
        Arrow.addPoint( s.getXTip(), s.getYTip() );
        Arrow.addPoint( s.getUpperLeftX(), s.getUpperLeftY()+s.getHeight() );
        g.fillPolygon( Arrow );    
    }
    
    /**
    * Draw graphical representation of this Circle.
    * @param g Graphics context where the drawing should occur
    */
    public void drawCircle(Graphics g,Circle s)
    {
        if(s.isSelected())
        {
            g.setColor(Color.BLACK);
            g.drawRect(s.getUpperLeftX(), s.getUpperLeftY(), s.getHeight(), s.getHeight());
        }
        g.setColor(s.getColor());
        g.fillOval(s.getUpperLeftX(), s.getUpperLeftY(), s.getHeight(), s.getHeight());
    }
    
    /**
    * Draw graphical representation of this Cross.
    * @param g Graphics context where the drawing should occur
    */
    public void drawCross(Graphics g,Cross s)
    {
        if(s.isSelected())
        {
            g.setColor(Color.BLACK);
            g.drawRect(s.getUpperLeftX(), s.getUpperLeftY(), s.getHeight(), s.getHeight());
        }
        g.setColor(s.getColor());
        g.fillRect(s.getUpperLeftX(),s.getUpperLeftY()+2*s.getHeight()/5,s.getHeight(),s.getHeight()/5);
        g.fillRect(s.getUpperLeftX()+2*s.getHeight()/5,s.getUpperLeftY(),s.getHeight()/5,s.getHeight());
       
    }
    
    /**
     * A method to make a random color. 
     * @return random Color
     */
    public Color randomColor()
    {
        int r=(int)(Math.random()*256);
        int g=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);
        return new Color(r,g,b);
    }
    
    /**
     * A method to draw the shape.
     * @param g graphics object,
     * @param s the shape we are going to draw
     */
    public void drawShape(Graphics g, Shape s)
    {
        if(s instanceof  Arrow)
        {
            drawArrow(g,(Arrow)s);
        }
        else if(s instanceof  Circle)
        {
            drawCircle(g,(Circle)s);
        }
        else if(s instanceof  Cross)
        {
            drawCross(g,(Cross)s);
        }
    }
    
}
