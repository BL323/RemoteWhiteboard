import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by BLourence on 26/02/15.
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
