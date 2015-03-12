import java.awt.*;
/**
 * Created by BLourence on 16/02/15.
 *
 * Makes use of Factory design pattern, client simply asks for a new IShape object and
 * the factory handles the instantiation logic. The program is not concerned with what underlying object
 * is returned only that it is of type IShape.
 */
public class ShapeFactory
{
    public IShape generateShape(ShapeType shapeType, Color colour, int size, Point position)
    {
        IShape shape = null;

        switch (shapeType)
        {
            case Circle:
                shape = new Circle(colour, size, position);
                break;
            case Triangle:
                shape = new Triangle(colour, size, position);
                break;
            case Square:
                shape = new Square(colour, size, position);
                break;
        }
        return shape;
    }

}
