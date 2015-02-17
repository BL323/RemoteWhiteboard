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
    public void SetSize()
    {

    }

    @Override
    public void draw(Graphics graphics)
    {
        Point pos = getPosition();
        graphics.drawOval(pos.x, pos.y, 30, 30);
    }


}
