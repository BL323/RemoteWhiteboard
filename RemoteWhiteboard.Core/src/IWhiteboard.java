import java.awt.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by BLourence on 15/02/15.
 *
 * Exposes methods that can be invoked remotely from client to server.
 *
 */

public interface IWhiteboard extends Remote
{
    void addShape(ShapeType shapeType, Color colour, int size, Point position) throws RemoteException;
    void clearWhiteboard() throws RemoteException;
    int noOfRegisteredClients() throws RemoteException;
    ArrayList<IShape> getCurrentShapes() throws RemoteException;

    //Callback Operations
    int registerClient(IClientCallback callback) throws RemoteException;
    void deregisterClient(IClientCallback iClientCallback) throws RemoteException;
}
