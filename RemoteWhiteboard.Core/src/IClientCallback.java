import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by BLourence on 26/02/15.
 */
public interface IClientCallback extends Remote
{
    void notifyUpdate() throws RemoteException;

}
