import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by BLourence on 26/02/15.
 *
 * Interface to facilitate updating individual clients via the notifyUpdate() method.
 */
public interface IClientCallback extends Remote
{
    void notifyUpdate() throws RemoteException;

}
