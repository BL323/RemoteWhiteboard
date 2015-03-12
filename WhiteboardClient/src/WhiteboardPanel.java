import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.event.MouseInputListener;

/**
 * Created by BLourence on 17/02/15.
 */
public class WhiteboardPanel extends JPanel implements MouseInputListener
{
    private WhiteboardClient whiteboardClient = null;

    //Constructor
    public WhiteboardPanel()
    {
        super();

        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.WHITE);

        repaint();
    }
    public void setWhiteboardClient(WhiteboardClient inputWhiteboardClient)
    {
        whiteboardClient = inputWhiteboardClient;
    }
    public void clearWhiteboard()
    {
        whiteboardClient.clearShapes();
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        ArrayList<IShape> shapes = whiteboardClient.getShapes();
        for(int shapeIndex = 0; shapeIndex < shapes.size(); shapeIndex++)
        {
            IShape shape = shapes.get(shapeIndex);
            graphics.setColor(shape.getColour());
            shape.draw(graphics);
        }
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        if(whiteboardClient.getCurrentShape() != null)
            whiteboardClient.addNewShape(mouseEvent.getPoint());
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {

    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {

    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {

    }
    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {

    }
    @Override
    public void mouseDragged(MouseEvent mouseEvent)
    {

    }
    @Override
    public void mouseMoved(MouseEvent mouseEvent)
    {

    }

    public void invokeRepaint()
    {
        repaint();
    }
}
