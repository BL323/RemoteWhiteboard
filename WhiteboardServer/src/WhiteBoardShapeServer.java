/**
 * Created by BLourence on 15/02/15.
 */
import java.awt.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class WhiteBoardShapeServer extends UnicastRemoteObject implements IWhiteboard
{
    //Singleton instance
    private static WhiteBoardShapeServer instance = null;

    private ArrayList<IShape> shapeList = new ArrayList<IShape>();
    private ShapeFactory shapeFactory = new ShapeFactory();

    //Constructor
    private WhiteBoardShapeServer() throws RemoteException
    {
        super();
        System.out.println("Starting whiteboard server....");
    }

    public void addShape(ShapeType shapeType, Color color, int size, Point point) throws RemoteException
    {
        //create and add shape as IShape
        IShape shape = shapeFactory.GenerateShape(shapeType, color, size, point);
        shapeList.add(shape);

        notifyClientsUpdate();

    }
    public void clearWhiteboard()
    {
        shapeList.clear();
        notifyClientsUpdate();
    }
    public ArrayList<IShape> getCurrentShapes()
    {
        return shapeList;
    }
    public int noOfRegisteredClients()
    {
        if(clientCallbacks != null)
            return clientCallbacks.size();

        return 0;
    }

    //Callbacks Section
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
    ArrayList<IClientCallback> clientCallbacks = new ArrayList<IClientCallback>();
    int clientNo = 1;

    public int registerClient(IClientCallback iClientCallback) throws RemoteException
    {
        clientCallbacks.add(iClientCallback);
        notifyClientsUpdate();
        //clientNo
        return 1;
    }
    public void deregisterClient(IClientCallback iClientCallback) throws RemoteException
    {
        clientCallbacks.remove(iClientCallback);
        notifyClientsUpdate();
    }

    public static WhiteBoardShapeServer getInstance()
    {
        if(instance != null)
            return instance;

        try
        {
            instance = new WhiteBoardShapeServer();

        }catch (Exception ex)
        {
            System.out.println("Error setting up up server instance: " + ex.getMessage());
            ex.getStackTrace();
        }

        return instance;
    }
}
