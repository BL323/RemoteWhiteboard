import java.awt.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by BLourence on 15/02/15.
 */
public class WhiteboardClient
{

    private IWhiteboard whiteboard = null;

    public void SetupClient()
    {
        try
        {
            whiteboard = (IWhiteboard) Naming.lookup("Whiteboard");

            IShape shape = new Square();
            //shape.SetColour(Color.black);
            shape.SetPosition(new Dimension(100,100));

            //adding initial shape
            whiteboard.AddShape(shape);
            ArrayList<IShape> listOfShapes = null;
            listOfShapes = whiteboard.GetCurrentShapes();

            System.out.println(listOfShapes.size());
        }
        catch (Exception ex)
        {
            System.out.println("Error setting up white board client: " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    public static void main(String[] args)
    {
        WhiteboardClient wc = new WhiteboardClient();
        wc.SetupClient();
    }
}
