import java.awt.*;

/**
 * Created by BLourence on 17/02/15.
 */
public class Triangle extends BaseShape implements IShape
{
    @Override
    public void SetSize()
    {

    }

    @Override
    public void draw(Graphics graphics)
    {
        Point pos = getPosition();

        int[] polyX = {pos.x-10, pos.x, pos.x+10};
        int[] polyY = {pos.y+20, pos.y, pos.y+20};
        Polygon poly = new Polygon(polyX, polyY, 3);

        graphics.drawPolygon(poly);
    }
}
