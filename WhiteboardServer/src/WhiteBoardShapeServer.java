import java.awt.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by BLourence on 15/02/15.
 *
 * ArrayList shapeList: is created to hold references to shape objects added to the whiteboard.
 *
 * ShapeFactory shapeFactory: generates shapes based on the information, returns IShape therefore the client
 * does not need to know how to create a shape it just asks via the factory.
 *
 * Callbacks:
 * ArrayList clientCallbacks: holds a list of clients that are registered for callbacks from the server.
 * registerClient(IClientCallback iClientCallback) is used to register a client for callbacks.
 * deregisterClient(IClientCallback iClientCallback) removes the passed client.
 * notifyClientsUpdate() causes each registered client to update it's whiteboard, connected client info.
 */

public class WhiteBoardShapeServer extends UnicastRemoteObject implements IWhiteboard
{
    private int clientNo = 1;
    private ShapeFactory shapeFactory = new ShapeFactory();
    private ArrayList<IShape> shapeList = new ArrayList<IShape>();
    private ArrayList<IClientCallback> clientCallbacks = new ArrayList<IClientCallback>();

    //Constructor
    public WhiteBoardShapeServer() throws RemoteException
    {
        super();
        System.out.println("Starting whiteboard server....");
    }
    public void addShape(ShapeType shapeType, Color color, int size, Point point) throws RemoteException
    {
        //create and add shape as IShape
        IShape shape = shapeFactory.generateShape(shapeType, color, size, point);
        shapeList.add(shape);

        notifyClientsUpdate();
    }
    public void clearWhiteboard()
    {
        shapeList.clear();
        notifyClientsUpdate();
    }
    public int noOfRegisteredClients()
    {
        if(clientCallbacks != null)
            return clientCallbacks.size();

        return 0;
    }
    public ArrayList<IShape> getCurrentShapes()
    {
        return shapeList;
    }


    //Callback Methods
    public void notifyClientsUpdate()
    {
        for(int i = 0; i < clientCallbacks.size(); i++)
        {
            try
            {
                clientCallbacks.get(i).notifyUpdate();
            }
            catch (Exception ex)
            {
                System.out.println("Error Notifying Clients: " + ex.getMessage());
            }
        }
    }
    public synchronized int registerClient(IClientCallback iClientCallback) throws RemoteException
    {
        clientCallbacks.add(iClientCallback);
        notifyClientsUpdate();
        return clientNo++;
    }
    public synchronized void deregisterClient(IClientCallback iClientCallback) throws RemoteException
    {
        if(clientCallbacks.contains(iClientCallback))
        {
            clientCallbacks.remove(iClientCallback);
            notifyClientsUpdate();
        }
    }
}
