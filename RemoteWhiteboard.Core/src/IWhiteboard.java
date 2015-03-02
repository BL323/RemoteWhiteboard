/**
 * Created by BLourence on 15/02/15.
 */
import java.awt.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

public interface IWhiteboard extends Remote
{
    //void AddShape(IShape shape) throws RemoteException;
    void addShape(ShapeType shapeType, Color colour, int size, Point position) throws RemoteException;
    void clearWhiteboard() throws RemoteException;
    int noOfRegisteredClients() throws RemoteException;
    ArrayList<IShape> getCurrentShapes() throws RemoteException;

    //Callback Operations
    int registerClient(IClientCallback callback) throws RemoteException;
    void deregisterClient(IClientCallback iClientCallback) throws RemoteException;
}
