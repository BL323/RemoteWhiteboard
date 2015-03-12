import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.rmi.Remote;

/**
 * Created by BLourence on 15/02/15.
 *
 * Enables generic handling of shape objects as IShape, therefore all shapes persisted as a single list of objects
 *
 * Exposes necessary methods required by other aspects of the application.s
 */
public interface IShape extends Remote
{
    Point getPosition();
    void setPosition(Point point);

    Color getColour();
    void setColour(Color colour);

    int getSize();
    void setSize(int s);

    void draw(Graphics graphics);
}
