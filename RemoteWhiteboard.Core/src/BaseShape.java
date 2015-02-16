import java.awt.*;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by BLourence on 15/02/15.
 */
public class BaseShape implements Serializable
{
    //Default Blue Colour
    private Color colour = Color.BLUE;
    private Dimension dimension = new Dimension(0,0);

    public void SetColour(Color inputColour)
    {
        colour = inputColour;
    }

    public void SetPosition(Dimension inputDimension)
    {
        dimension = inputDimension;
    }


}
