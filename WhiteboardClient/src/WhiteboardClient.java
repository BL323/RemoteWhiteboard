import java.awt.*;
import java.lang.reflect.Array;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * Created by BLourence on 15/02/15.
 */
public class WhiteboardClient
{
    private int size = 30;
    public int getSize(){return size;}
    public void setSize(int inputSize){size = inputSize;}

    private Color colour;
    public Color getColour(){return colour;}
    public void setColour(Color inputColour){colour = inputColour;}

    private IWhiteboard whiteboard = null;
    private static WhiteboardView whiteboardView = null;
    private IClientCallback callbackClient = null;

    private ArrayList<IShape> shapes;


    private ShapeType currentShape;
    public ShapeType getCurrentShape()
    {
    return currentShape;
    }
    public void setSelectedShape(ShapeType newSelectedShape)
    {
        if(newSelectedShape != currentShape)
            currentShape = newSelectedShape;
    }
    public void SetupClient()
    {
        try
        {
            whiteboard = (IWhiteboard) Naming.lookup("Whiteboard");
            System.out.println("Whiteboard initialised....");

            System.out.println("Retrieving current whiteboard shapes");
            shapes = whiteboard.getCurrentShapes();

            callbackClient = new ClientCallback(this);
            whiteboard.registerClient(callbackClient);
        }
        catch (Exception ex)
        {
            System.out.println("Error setting up white board client: " + ex.getMessage());
            ex.getStackTrace();
        }
    }
    public void updateClient()
    {
        GetCurrentShapes();
        whiteboardView.invokeRepaint();
    }
    public void clearShapes()
    {
        try
        {
            whiteboard.clearWhiteboard();
            whiteboardView.invokeRepaint();
        }
        catch(Exception ex)
        {
            System.out.println("Error Clearing Whiteboard: " + ex.getMessage());
            ex.getStackTrace();
        }
    }
    public void AddNewShape(Point point)
    {
        try
        {
            whiteboard.addShape(getCurrentShape(), getColour(), getSize(), point);

            //invoke from call back
            shapes = whiteboard.getCurrentShapes();
            whiteboardView.invokeRepaint();
        }
        catch(Exception ex)
        {
            System.out.println("Error adding new shape: " + ex.getMessage());
            ex.getStackTrace();
        }
    }
    public ArrayList<IShape> GetCurrentShapes()
    {
        ArrayList<IShape> currentShapes = null;
        try
        {
            currentShapes = whiteboard.getCurrentShapes();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return currentShapes;
    }

    public static void main(String[] args)
    {
        WhiteboardClient wc = new WhiteboardClient();
        wc.SetupClient();

        whiteboardView = new WhiteboardView();
        whiteboardView.SetController(wc);

        //init GUI
        whiteboardView.ShowForm();
    }
}
