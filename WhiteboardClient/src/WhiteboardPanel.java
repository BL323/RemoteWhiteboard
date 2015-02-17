import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import java.util.ArrayList;

/**
 * Created by BLourence on 17/02/15.
 */
public class WhiteboardPanel extends JPanel implements MouseInputListener
{
    private WhiteboardClient whiteboardClient = null;

    //FOR LOCAL TESTING
    private ArrayList<IShape> localShapes = new ArrayList<IShape>();
    private ShapeFactory shapeFactory = new ShapeFactory();


    public void SetWhiteboardClient(WhiteboardClient inputWhiteboardClient)
    {
        whiteboardClient = inputWhiteboardClient;
    }
    public WhiteboardPanel()
    {
        super();

        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.WHITE);

        repaint();
    }

    public void clearWhiteboard()
    {
        localShapes.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

//        ArrayList<IShape> curShapes = whiteboardClient.GetCurrentShapes()

        for(int shapeIndex = 0; shapeIndex < localShapes.size(); shapeIndex++)
        {
            IShape shape = localShapes.get(shapeIndex);
            shape.draw(graphics);
        }

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        System.out.println("Clicked: " + mouseEvent.getPoint());

        if(whiteboardClient.getCurrentShape() != null)
        {
            Point p = mouseEvent.getPoint();
            IShape shape = shapeFactory.GenerateShape(whiteboardClient.getCurrentShape(), p);
            localShapes.add(shape);
            repaint();
        }
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
}
