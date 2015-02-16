/**
 * Created by BLourence on 15/02/15.
 */
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class WhiteBoardShapeServer extends UnicastRemoteObject implements IWhiteboard
{
    //Singleton instance
    private static WhiteBoardShapeServer instance = null;

    private ArrayList<IShape> shapeList = new ArrayList<IShape>();

    //Constructor
    private WhiteBoardShapeServer() throws RemoteException
    {
        super();
        System.out.println("Starting whiteboard server....");
    }


    public void AddShape(IShape shape)
    {
        shapeList.add(shape);
    }
    public void ClearWhiteboard()
    {
        shapeList.clear();
    }
    public ArrayList<IShape> GetCurrentShapes()
    {
        return shapeList;
    }


    public static WhiteBoardShapeServer GetInstance()
    {
        if(instance != null)
            return instance;

        try
        {
            instance = new WhiteBoardShapeServer();

        }catch (Exception ex)
        {
            System.out.println("Error setting up up server instance: " + ex.getMessage());
            ex.getStackTrace();
        }

        return instance;
    }
}
