package Week2.HW2;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A method to show a text representation of the drawing board through System.out.println(). 
 * This class also uses a JTextArea to display the information on the frame.
 * @author Oscar Morales
 * @version 1/31/15
 */
public class TextView extends JPanel implements DrawingBoardListener
{
    private DrawingBoard db;
    JTextArea area; 
    
    /**
     * Constructs a TextView object. And also creates a JTextArea that is placed
     * in a JScrollPane. And is set to not be editable.
     * @param db the DrawingBoard
     */
    public TextView(DrawingBoard db)
    {
        this.setBackground(Color.BLACK);
        this.db=db;
        area= new JTextArea(8, 28);
        this.setPreferredSize( new Dimension( 105, 105 ) );
        
        JScrollPane scrollPane = new JScrollPane(area); 
        this.add(scrollPane);
        area.setEditable(false);
        db.addListener( this );  
    }
    
    /**
     * Displays information about the DrawigBoard. Both to System.out.println()
     * and JTextArea.
     */
    public void drawingBoardChanged()
    {
        if(db.getSize()==0)
        {
            System.out.println("No shapes in Drawing Board");
            area.setText("No shapes in Drawing Board");
        }
        else
        {
            if(db.getSelectedShape()==null)
            {
                System.out.println("Current number of Shapes in DrawingBoard "+db.getSize()+".\nNo shape currently Selected");
                area.setText("Current number of Shapes in DrawingBoard "+db.getSize()+".\nNo shape currently Selected");
            }

            else
            {
                System.out.println("Current numbers of Shapes in DrawingBoard "+db.getSize()+".\n"+db.getSelectedShape().toString());
                area.setText("Current numbers of Shapes in DrawaingBoard "+db.getSize()+".\n"+"Current Selected Shape:\n"+db.getSelectedShape().toString());
            }
        }
        repaint();  
    }
}
