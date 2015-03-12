import java.awt.*;

/**
 * Created by BLourence on 15/02/15.
 *
 * Provides overridden draw(Graphics graphics) method and implements as IShape
 *
 */
public class Square extends BaseShape implements IShape
{
    public Square(Color inputColour, int inputSize, Point inputPosition)
    {
        super(inputColour, inputSize, inputPosition);
    }

    @Override
    public void draw(Graphics graphics)
    {
        Point pos = getPosition();
        graphics.setColor(getColour());
        graphics.fillRect(pos.x, pos.y, getSize(), getSize());
    }
}
