import java.awt.*;
import java.io.Serializable;
import java.rmi.Naming;
import java.util.ArrayList;
/**
 * Created by BLourence on 15/02/15.
 */
public class WhiteboardClient implements Serializable
{
    //Private Fields
    private int clientNumber = 0;
    private int connectedClients = 0;
    private int size = 30;
    private IWhiteboard whiteboard = null;
    private static WhiteboardView whiteboardView = null;
    private ClientCallback callBackClient = null;
    private ArrayList<IShape> shapes;
    private Color colour = Color.black;
    private ShapeType currentShape;

    //Public Properties
    public int getClientNumber() {return clientNumber;}
    public int getConnectedClients(){return connectedClients;}
    public ArrayList<IShape> getShapes(){return shapes;}
    public int getSize(){return size;}
    public void setSize(int inputSize){size = inputSize;}
    public Color getColour(){return colour;}
    public void setColour(Color inputColour){colour = inputColour;}
    public ShapeType getCurrentShape()
    {
    return currentShape;
    }
    public void setSelectedShape(ShapeType newSelectedShape)
    {
        if(newSelectedShape != currentShape)
            currentShape = newSelectedShape;
    }

    private void setupClient()
    {
        try
        {
            whiteboard = (IWhiteboard) Naming.lookup("Whiteboard");
            System.out.println("Whiteboard initialised....");

            //register client for callbacks
            IClientCallback callbackClients = new ClientCallback();
            clientNumber = whiteboard.registerClient(callbackClients);

            callBackClient = (ClientCallback)callbackClients;
            callBackClient.setWhiteboardClient(this);

            System.out.println("Retrieving current whiteboard shapes");
            shapes = whiteboard.getCurrentShapes();
            connectedClients = getNumberOfClients();
        }
        catch (Exception ex)
        {
            System.out.println("Error setting up white board client: " + ex.getMessage());
            ex.getStackTrace();
        }
    }
    private int getNumberOfClients()
    {
        int result = 0;
        try
        {
            result = whiteboard.noOfRegisteredClients();
        }
        catch(Exception ex)
        {
            System.out.println("Error adding new shape: " + ex.getMessage());
            ex.getStackTrace();
        }
        return result;
    }
    private ArrayList<IShape> GetCurrentShapes()
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
    public void updateClient()
    {
        shapes = GetCurrentShapes();
        connectedClients = getNumberOfClients();
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
    public void addNewShape(Point point)
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
    public void deregisterClient()
    {
        IClientCallback iClientCallBack = callBackClient;
        try
        {
            whiteboard.deregisterClient(iClientCallBack);
        }
        catch (Exception ex)
        {
            System.out.println("Error setting up white board client: " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    public static void main(String[] args)
    {
        WhiteboardClient wc = new WhiteboardClient();
        wc.setupClient();

        whiteboardView = new WhiteboardView();
        whiteboardView.setController(wc);

        //init GUI
        whiteboardView.showForm();
    }
}
