import java.awt.*;
/**
 * Created by BLourence on 16/02/15.
 */
public class ShapeFactory
{
    public IShape GenerateShape(ShapeType shapeType, Color colour, int size, Point position)
    {
        IShape shape = null;

        switch (shapeType)
        {
            case Circle:
                shape = new Circle(colour, size, position);
                break;
            case Trianlge:
                shape = new Triangle(colour, size, position);
                break;
            case Rectanlge:
                shape = new Rectangle(colour, size, position);
                break;
        }
        return shape;
    }

}
