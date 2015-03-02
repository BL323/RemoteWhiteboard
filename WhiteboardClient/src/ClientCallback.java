import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * Created by BLourence on 26/02/15.
 */
public class ClientCallback implements IClientCallback, Serializable
{
    private WhiteboardClient whiteboardClient;

    //Constructor
    public ClientCallback(WhiteboardClient inputWhiteboardClient)
    {
        whiteboardClient = inputWhiteboardClient;
    }

    @Override
    public void notifyUpdate() throws RemoteException
    {
        if(whiteboardClient != null)
            whiteboardClient.updateClient();
    }
}
