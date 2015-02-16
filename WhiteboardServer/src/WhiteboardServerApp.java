import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by BLourence on 15/02/15.
 */
public class WhiteboardServerApp
{
    public static void main(String[] args)
    {

        try
        {
            //creates registry instance in JavaVm
            Registry reg = LocateRegistry.createRegistry(1099);
            WhiteBoardShapeServer server = WhiteBoardShapeServer.GetInstance();

            Naming.rebind("Whiteboard", server);
            System.out.println("Whiteboard server bound in reg..");
        }
        catch(Exception ex)
        {
            System.out.println("Error creating JVM reg " + ex.getMessage());
            ex.getStackTrace();
        }
    }
}