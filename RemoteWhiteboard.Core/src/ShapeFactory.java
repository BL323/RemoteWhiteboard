import java.awt.*;
/**
 * Created by BLourence on 16/02/15.
 */
public class ShapeFactory
{
    public IShape GenerateShape(ShapeEnum shapeEnum, Point point)
    {
        IShape shape = null;

        switch (shapeEnum)
        {
            case Circle:
                shape = new Circle();
                break;
            case Rectanlge:
                shape = new Rectangle();
                break;
            case Trianlge:
                shape = new Triangle();
                break;
        }

        shape.setPosition(point);
        return shape;
    }
}
