import java.awt.*;

/**
 * Created by BLourence on 15/02/15.
 */
public class Rectangle extends BaseShape implements IShape
{
    public void SetSize()
    {

    }

    @Override
    public void draw(Graphics graphics)
    {
        Point pos = getPosition();
        graphics.drawRect(pos.x, pos.y, 30, 30);
    }
}
