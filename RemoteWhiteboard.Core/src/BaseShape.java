import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by BLourence on 15/02/15.
 */
public abstract class BaseShape implements Serializable
{
    private int size = 30;
    private Point position;
    //Default Blue Colour
    private Color colour = Color.BLUE;
    public Color getColour(){return colour;}
    public void setColour(Color inputColour){colour = inputColour;}

    public int getSize(){return size;}
    public void setSize(int s){size = s;}

    public Point getPosition(){return position; }
    public void setPosition(Point p){ position = p; }


    //Constructor
    public BaseShape(Color inputColour, int inputSize, Point inputPosition)
    {
        colour = inputColour;
        size = inputSize;
        position = inputPosition;
    }

}
