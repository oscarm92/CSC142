package Week2.HW2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class keeps track of a list of Shapes, it should also keep track of a selected shape. 
 * The Shapes are stored in order, from index 0 (the Shape furthest back when displayed) 
 * to the last index (the Shape that is drawn last). This DrawingBoard also keeps
 * track of a list of listeners and notifies them when something has changed.
 * @author Oscar Morales
 * @version 1/21/15
 */
public class DrawingBoard 
{
    private ArrayList<Shape> list; //An ArrayList to contain Shapes.
    
    private ArrayList<DrawingBoardListener> listeners; //An ArrayList to contain registered listeners.
    
    /**
     * A DrawingBoard constructor that creates a ArrayList and a list of Listeners. 
     */
    public DrawingBoard()
    {
        list=new ArrayList<>();
        listeners=new ArrayList<>();
    }
    
    /**
     * A method to add a Shape to the DrawingBoard. This added Shape becomes the 
     * selected shape. Also notifies all listeners.
     * @param s Shape to be added.
     */
    public void addShape(Shape s)
    {
        if(list.isEmpty())
        {
            list.add(s);
            s.setSelected(true);
        }
        else
        {
            setSelectedShapeToFalse();
            list.add(s);
            s.setSelected(true);
        }
        notifyAllListeners();
    }
    
    /**
     * A method to set to current selected shape from true to false. 
     * Also notifies all listeners.
     */
    public void setSelectedShapeToFalse()
    {
        Iterator<Shape> it = list.iterator();
        while (it.hasNext()) 
        {
            Shape s = it.next();
            if(s.isSelected())
            s.setSelected(false);
        }  
        notifyAllListeners();
    }
    
    /**
     * This method passes in an x,y coordinate, and the topmost shape that contains 
     * this x,y coordinate becomes the selected shape. If no shape contains the 
     * point (x,y) , then no shape is the selected shape. Also notifies all listeners.
     * @param x point x
     * @param y point y
     */
    public void setSelectedShapeXY(int x, int y)
    {   
        for(int i=list.size()-1; i>=0; i--)
        {
            setSelectedShapeToFalse();
            if(list.get(i).isOn(x, y))
            {
                Shape s = list.get(i);
                list.remove(i);
                list.add(s);
                s.setSelected(true);
                notifyAllListeners();
                return;
            }
        }
    }
    
    /**
     * This method retrieves a reference to the selected shape. This returns null 
     * if no Shape is currently selected.
     * @return Shape that is selected
     */
    public Shape getSelectedShape()
    {
        Shape s=null;
        Iterator<Shape> it = list.iterator();
        while (it.hasNext()) 
        {
            Shape selected = it.next();
            if(selected.isSelected())
            {
                s=selected;
            }
        }   
        return s;
    }
    
    /**
     * This method removes the selected shape from the DrawingBoard. If no shape 
     * is currently selected, then it throws an IllegalStateException. If the 
     * selected shape is removed, then the topmost shape becomes the selected 
     * shape. If after the removal the DrawingBoard is empty, 
     * then nothing is selected. Also notifies all listeners.
     * @throws IllegalStateException if no shape is selected
     */
    public void removeSelectedShape()
    {
        if(getSelectedShape()==null)
        {
            throw new IllegalStateException("No shape is selected");
        }
        list.remove(getSelectedShape());
        if(!list.isEmpty())
            list.get(list.size()-1).setSelected(true);
        notifyAllListeners();
    }
    
    /**
     * This method changes the color of the selected shape. If no Shape is 
     * currently selected, it throws an IllegalStateException exception.
     * Also notifies all listeners.
     * @param c Color of Shape
     * @throws IllegalStateException if no shape is selected
     */
    public void setSelectedShapeColor(Color c)
    {
        if(getSelectedShape()==null)
            throw new IllegalStateException("No shape is selected");
        getSelectedShape().setColor(c);
        notifyAllListeners();
    }
    
    /**
     * A client should be able to pass in a x, y point and the DrawingBoard 
     * moves the selected shape to the x and y point. If no shape is selected, it 
     * throws an IllegalStateException exception. Also notifies all listeners.
     * @param x amount to move x 
     * @param y amount to move y
     * @throws IllegalStateException if no shape is selected
     */
    public void moveSelectedShape(int x, int y)
    {
        if(getSelectedShape()==null)
            throw new IllegalStateException("No shape is selected");
        getSelectedShape().moveUpperLeftTo(x, y);
        notifyAllListeners();
    }
    
    /**
     * A client should be able to pass in a changeInX, changeInX and the DrawingBoard 
     * moves the selected shape by those amounts. If no shape is selected, it 
     * throws an IllegalStateException exception. Also notifies all listeners.
     * @param changeInX amount to move x 
     * @param changeInY amount to move y
     * @throws IllegalStateException if no shape is selected
     */
    public void shiftSelectedShape(int changeInX, int changeInY)
    {
        if(getSelectedShape()==null)
            throw new IllegalStateException("No shape is selected");
        getSelectedShape().shiftUpperLeftBy(changeInX, changeInY);
        notifyAllListeners();
    }
    
    /**
     * This method retrieves a copy of the List of shapes in the DrawingBoard. 
     * @return new ArrayList 
     */
    public ArrayList<Shape> getListOfShapes()
    {             
        return new ArrayList<>(list);
    }

    // operations to support listeners
    /**
     * Add a new listener to the list only if the listener is not null.
     * @param c the new listener
     */
    public void addListener( DrawingBoardListener c ) 
    {
        if ( c != null ) 
        {
            listeners.add( c );
            c.drawingBoardChanged(); // update new listener 
        }
    }
  
    /**
     * A method to notify all the listeners that something has changed.
     */
    private void notifyAllListeners() 
    {
        Iterator<DrawingBoardListener> it = listeners.iterator();
        while ( it.hasNext() ) 
        {
            DrawingBoardListener c = it.next();
            c.drawingBoardChanged();
        }
    }
  
    /**
     * A method to get the size of the Drawing Board.
     * @return the length of the Drawing Board
     */
    public int getSize()
    {
        return list.size();
    }
  
    /**
     * A method to return the a shape at a given index.
     * @param index of the shape in the list.
     * @return the Shape at that index.
     */
    public Shape getShapeAtIndex(int index)
    {
        return list.get(index);
    }
  
    /**
     * Remove all the shapes from the Drawing Board.
     */
    public void clearDrawingBoard()
    {
        list.clear();
        notifyAllListeners();
    }
  
}
