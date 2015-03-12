import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by BLourence on 15/02/15.
 *
 * Entry point of the server application.
 * Creates a registry within the Jvm of the app and then binds the whiteboard implementation.
 * WhiteBoardShapeServer is bound into the reg while WhiteServerApp acts as host
 */
public class WhiteboardServerApp
{
    public static void main(String[] args)
    {
        try
        {
            //creates registry instance in JavaVm
            Registry reg = LocateRegistry.createRegistry(1099);
            WhiteBoardShapeServer server = new WhiteBoardShapeServer();

            Naming.rebind("Whiteboard", server);
            System.out.println("Whiteboard server bound in Jvm reg...");
        }
        catch(Exception ex)
        {
            System.out.println("Error creating JVM reg " + ex.getMessage());
            ex.getStackTrace();
        }
    }
}
