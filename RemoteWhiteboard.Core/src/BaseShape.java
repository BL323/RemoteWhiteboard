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
public abstract class BaseShape implements Serializable, Shape
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
    public void setPosition(Point p)
    {
        position = p;
    }

    public void SetColour(Color inputColour)
    {
        colour = inputColour;
    }

    //Constructor
    public BaseShape(Color inputColour, int inputSize, Point inputPosition)
    {
        colour = inputColour;
        size = inputSize;
        position = inputPosition;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public boolean contains(double v, double v1) {
        return false;
    }

    @Override
    public boolean contains(Point2D point2D) {
        return false;
    }

    @Override
    public boolean intersects(double v, double v1, double v2, double v3) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D rectangle2D) {
        return false;
    }

    @Override
    public boolean contains(double v, double v1, double v2, double v3) {
        return false;
    }

    @Override
    public boolean contains(Rectangle2D rectangle2D) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform, double v) {
        return null;
    }

}
