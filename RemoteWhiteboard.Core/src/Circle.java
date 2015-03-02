import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by BLourence on 15/02/15.
 */
public class Circle extends BaseShape implements IShape
{
    public Circle(Color inputColour, int inputSize, Point inputPosition)
    {
        super(inputColour, inputSize, inputPosition);
    }

    @Override
    public void draw(Graphics graphics)
    {
        Point pos = getPosition();
        graphics.setColor(getColour());
        graphics.fillOval(pos.x, pos.y, getSize(), getSize());
    }


}
