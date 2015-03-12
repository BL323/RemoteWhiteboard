import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by BLourence on 26/02/15.
 *
 * ClientCallback defines a class that can be used to register clients on the server.
 * Implementing IClientCallback facilitates notifyUpdate() which allows the server to
 * notify the client when it should update, instead of polling to see if a change has occured.
 */
public class ClientCallback extends UnicastRemoteObject implements IClientCallback, Serializable
{
    private WhiteboardClient whiteboardClient;

    protected ClientCallback() throws RemoteException
    {
    }

    public void setWhiteboardClient(WhiteboardClient inputWhiteboardClient)
    {
        whiteboardClient = inputWhiteboardClient;
    }
    public void notifyUpdate() throws RemoteException
    {
        if(whiteboardClient != null)
            whiteboardClient.updateClient();
    }
}
