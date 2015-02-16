/**
 * Created by BLourence on 15/02/15.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IWhiteboard extends Remote
{
    void AddShape(IShape shape) throws RemoteException;
    void ClearWhiteboard() throws RemoteException;
    ArrayList<IShape> GetCurrentShapes() throws RemoteException;
}
