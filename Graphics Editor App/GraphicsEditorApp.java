package Week2.HW2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GraphicsEditorApp class that contain a main method. It create a JFrame, DrawingBoard, 
 * and the 2 VIEWs.
 * @author Oscar Morales
 * @version 1/31/15
 */
public class GraphicsEditorApp implements ActionListener,MouseListener,MouseMotionListener,KeyListener
{
    private String shape="";
    private DrawingBoard db;
    private boolean option;
    private boolean dragging; 
    int xstart;
    int ystart;
    private GraphicView gv;
    
    /**
     * Creates the GraphicsEditorApp. We also make some some JPanels and some buttons
     * to those panels. Then we add addActionListener to the buttons and set them
     * to not focusable so the user can click on the keys to use them. Then we add
     * to the GraphicView a MouseListener, MouseMotionListener, KeyListener and make 
     * it Focusable. At the end we set the frame BorderLayout and place all the 
     * components there.
     */
    public GraphicsEditorApp()
    { 
        JPanel south = new JPanel(new GridLayout(2,3) );
        south.setBackground(Color.red);
        
        JButton circle = new JButton("Draw Circle");
        south.add(circle);  
        circle.addActionListener( this );
        circle.setFocusable(false);
 
        JButton cross = new JButton("Draw Cross");
        south.add(cross);
        cross.addActionListener( this );
        cross.setFocusable(false);
        
        JButton arrow = new JButton("Draw Arrow");
        south.add(arrow);
        arrow.addActionListener( this );
        arrow.setFocusable(false);
        
        JButton randcolor = new JButton("Random Color");
        south.add(randcolor);
        randcolor.addActionListener( this );
        randcolor.setFocusable(false);
        
        JButton stop = new JButton("Stop Drawing");
        south.add(stop);
        stop.addActionListener( this );
        stop.setFocusable(false);
        
        JButton delete = new JButton("Remove Selected Shape(Or Press R)");
        south.add(delete);
        delete.addActionListener( this );
        delete.setFocusable(false);
        
        JButton clear = new JButton("Clear Drawing Board(Or Press C)");
        south.add(clear);
        clear.addActionListener( this );
        clear.setFocusable(false);
        
        JButton quit = new JButton("Quit(Or Press Q)");
        south.add(quit);
        quit.addActionListener( this );
        quit.setFocusable(false);
       
        db = new DrawingBoard();      
        TextView tv = new TextView(db);
        gv = new GraphicView(db);
        
        gv.addMouseListener(this);
        gv.addMouseMotionListener(this);
        gv.setFocusable(true);
        gv.addKeyListener(this);
       
        JFrame frame = new JFrame("GraphicsEditorApp");  
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setLayout(new BorderLayout());
        frame.add(gv, BorderLayout.NORTH);
        frame.add(south, BorderLayout.CENTER);
        frame.add(tv, BorderLayout.SOUTH);
        frame.setBackground(Color.WHITE);
        frame.pack( ); 
        frame.setLocationRelativeTo(null);
        frame.setVisible( true );
    }
    
    /**
     * Sets the actionPerformed from the buttons clicked. This method saves the
     * ActionCommand in a String and sets the boolean variable option to true only
     * if they clicked to draw a Shape. There is also some buttons to stop drawing 
     * and make a radom color. You can also remove a selected shape or clear the
     * drawing board and quit. 
     * @param event 
     */
    public void actionPerformed(ActionEvent event) 
    {        
        if ( event.getActionCommand( ).equals( "Draw Circle" ) ) 
        {
            shape=event.getActionCommand();
            option=true;
            
        } 
        else if ( event.getActionCommand( ).equals( "Draw Cross" ) ) 
        {
            shape=event.getActionCommand();
            option=true;
        } 
        else if ( event.getActionCommand( ).equals( "Draw Arrow" ) ) 
        {
             shape=event.getActionCommand();
             option=true;
        }
        else if ( event.getActionCommand( ).equals( "Stop Drawing" ) ) 
        {
             shape="stop";
             option=false;
             db.setSelectedShapeToFalse();
        }
        else if ( event.getActionCommand( ).equals( "Random Color" ) ) 
        {
            if(db.getSelectedShape()!=null)
            {
                db.getSelectedShape().setColor(gv.randomColor());
                gv.repaint();
            }  
        }
        else if ( event.getActionCommand( ).equals( "Remove Selected Shape(Or Press R)" ) ) 
        {
             if(db.getSelectedShape()!=null)
             db.removeSelectedShape();
        }
        else if ( event.getActionCommand( ).equals( "Clear Drawing Board(Or Press C)" ) ) 
        {
            db.clearDrawingBoard();
        }
        else if ( event.getActionCommand( ).equals( "Quit(Or Press Q)" ) ) 
        {
            System.exit(0);
        }
    }
    
    /**
     * When the user clicks on the drawing board it draws shapes in the drawing window 
     * (circles, arrows and crosses). The click represent those "key" locations of the Shape.
     * @param e 
     */  
    public void mouseClicked( MouseEvent e ) 
    {
        if(option)
        {
            if ( shape.equals( "Draw Circle" ) ) 
            {
                Circle c = new Circle(e.getX( ),e.getY( ),10);
                db.addShape(c);
            } 
            else if ( shape.equals( "Draw Cross" ) ) 
            {

                Cross c = new Cross(e.getX( ),e.getY( ),20);
                db.addShape(c);
            } 
            else if ( shape.equals( "Draw Arrow" ) ) 
            {
                 Arrow a = new Arrow(e.getX( ),e.getY( ),20);
                 db.addShape(a);
            }
        }
        else 
        {
            db.setSelectedShapeXY(e.getX( ),e.getY( ));
        }        
    }
    
    /**
     * This method saves the location of where the mouse was pressed in xstart
     * and ystart. You can also select the a shape.
     * @param e 
     */
    public void mousePressed ( MouseEvent e ) 
    { 
        xstart=e.getX();
        ystart=e.getY();
        if(!option)
        {
            db.setSelectedShapeXY(e.getX( ),e.getY( ));
        }
    }
      
    /**
     * When the mouse is released it Adds the shape to Drawing Board.
     * @param e 
     */
    public void mouseReleased( MouseEvent e ) 
    {
        if(dragging)
        {
            int d=(int)Math.sqrt(Math.pow(xstart-e.getX(), 2)+Math.pow(ystart-e.getY(), 2));
            
            if(option)
            {
                if( shape.equals( "Draw Circle" ) ) 
                {
                    Circle c = new Circle(xstart,ystart,d);
                    db.addShape(c);
                } 
                else if ( shape.equals( "Draw Cross" ) ) 
                {
                    if(d%5!=0)
                    {
                        d+=5-d%5;
                    }
                    Cross c = new Cross(xstart,ystart,d);
                    db.addShape(c);
                } 
                else if ( shape.equals( "Draw Arrow" ) ) 
                {
                    if(d%2!=0)
                    {
                        d+=2-d%2;
                    }
                    Arrow a = new Arrow(xstart,ystart,d);
                    db.addShape(a);
                }
            }
        }
        dragging=false;
        gv.setTempShape(null);
    }
  
    /**
     * When the user clicks the button and drags it draws a shape temp and keeps drawing 
     * one for as long as the user drags the shape. It also saves the distance.
     * and sets the dragging variable to true.
     * @param e 
     */
    public void mouseDragged( MouseEvent e ) 
    {
        dragging=true;

        int d=(int)Math.sqrt(Math.pow(xstart-e.getX(), 2)+Math.pow(ystart-e.getY(), 2));

        if(option)
        {         
            if( shape.equals( "Draw Circle" ) ) 
            {
                Circle c = new Circle(xstart,ystart,d);
                gv.setTempShape(c);
            } 
            else if ( shape.equals( "Draw Cross" ) ) 
            {
                if(d%5!=0)
                {
                    d+=5-d%5;
                }
                Cross c = new Cross(xstart,ystart,d);
                gv.setTempShape(c);
            } 
            else if ( shape.equals( "Draw Arrow" ) ) 
            {
                if(d%2!=0)
                {
                    d+=2-d%2;
                }
                Arrow a = new Arrow(xstart,ystart,d);
                gv.setTempShape(a);
            }
        }
        else
        {
            if(db.getSelectedShape()!=null)
            db.moveSelectedShape(e.getX(), e.getY());
        }
    }
    
    // dummy implementations for other events in mouselistener     
    public void mouseEntered ( MouseEvent e ) { }
    public void mouseExited ( MouseEvent e ) { }
    public void mouseMoved (MouseEvent e){ }
  
    /**
     * If the user types R it removes the selected shape, If the user presses C
     * it clears the drawing board.
     * @param e 
     */
    public void keyTyped(KeyEvent e) 
    {
        if(e.getKeyChar()=='r'||e.getKeyChar()=='R')
        {
            if(db.getSelectedShape()!=null)
            db.removeSelectedShape();     
        }
        else if(e.getKeyChar()=='c'||e.getKeyChar()=='C')
            db.clearDrawingBoard();    
        else if(e.getKeyChar()=='q'||e.getKeyChar()=='Q')
            System.exit(0);
    }
    
    // dummy implementations for other events in KeyListener  
    public void keyPressed(KeyEvent e){ }
    public void keyReleased(KeyEvent e){ }
   
    /**
     * Runs the program.
     * @param args not used.
     */
    public static void main(String[] args) 
    {
        GraphicsEditorApp gea = new GraphicsEditorApp();
    }

}
