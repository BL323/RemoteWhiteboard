import java.awt.*;
import java.lang.reflect.Array;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * Created by BLourence on 15/02/15.
 */
public class WhiteboardClient
{
    private ShapeFactory shapeFactory = null;
    private IWhiteboard whiteboard = null;
    private ArrayList<IShape> shapes = null;

    private boolean initShapeSelected = false;

    private ShapeEnum currentShape;
    public ShapeEnum getCurrentShape()
    {
    return currentShape;
    }
    public void setSelectedShape(ShapeEnum newSelectedShape)
    {
        if(newSelectedShape != currentShape)
            currentShape = newSelectedShape;
    }

    public void SetupClient()
    {
        try
        {
            whiteboard = (IWhiteboard) Naming.lookup("Whiteboard");
            System.out.println("Whiteboard initialised....");

            System.out.println("Retrieving current whiteboard shapes");
            shapes = whiteboard.GetCurrentShapes();

            shapeFactory = new ShapeFactory();
        }
        catch (Exception ex)
        {
            System.out.println("Error setting up white board client: " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    public void AddNewShape(ShapeEnum shapeEnum)
    {
//        try
//        {
         //   IShape shape = shapeFactory.GenerateShape(shapeEnum, null);
         //   whiteboard.AddShape(shape);
//        }
//        catch (Exception ex)
//        {
//            System.out.println("Error adding new shape: " + ex.getMessage());
//            ex.getStackTrace();
//        }
    }

    public ArrayList<IShape> GetCurrentShapes()
    {
        ArrayList<IShape> jk = null;
        try
        {
            jk = whiteboard.GetCurrentShapes();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return jk;
    }

    public static void main(String[] args)
    {
        WhiteboardClient wc = new WhiteboardClient();
        //wc.SetupClient();

        WhiteboardView whiteboardView = new WhiteboardView();
        whiteboardView.SetController(wc);

        whiteboardView.ShowForm();


        //set up GUI
        //wc.AddNewShape(ShapeEnum.Circle);
        //wc.AddNewShape(ShapeEnum.Square);

        //ArrayList<IShape> t = wc.GetCurrentShapes();
        //System.out.println("Shape List Length: " + t.size());
    }
}
