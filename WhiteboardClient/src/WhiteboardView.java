import javax.swing.*;
import java.awt.event.*;

/**
 * Created by BLourence on 16/02/15.
 */
public class WhiteboardView implements ActionListener
{
    private JButton clearBtn;
    private JButton circleBtn;
    private JButton triangleBtn;
    private JButton rectangleBtn;

    private JPanel panel1;
    private JPanel WhiteboardContainerPannel;
    private WhiteboardPanel whiteboardPannel;

    private WhiteboardClient whiteboardClient = null;


    public WhiteboardView()
    {
        //Button Listeners
        rectangleBtn.addActionListener(this);
        circleBtn.addActionListener(this);
        triangleBtn.addActionListener(this);
        clearBtn.addActionListener(this);
    }


    public void SetController(WhiteboardClient inputController)
    {
        whiteboardClient = inputController;
        whiteboardPannel.SetWhiteboardClient(inputController);
    }

    public void ShowForm()
    {
        JFrame frame = new JFrame("MyForm");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(700,450);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String act = actionEvent.getActionCommand();
        if(act.equals("Rectangle"))
        {
            System.out.println("Rectangle Button Pressed...");
            whiteboardClient.setSelectedShape(ShapeEnum.Rectanlge);
            //whiteboardClient.AddNewShape(ShapeEnum.Square);

        }
        else if(act.equals("Triangle"))
        {
            System.out.println("Triangle Button Pressed..");
            whiteboardClient.setSelectedShape(ShapeEnum.Trianlge);
            //whiteboardClient.AddNewShape(ShapeEnum.);
        }
        else if(act.equals("Circle"))
        {
            System.out.println("Circle Button Pressed..");
            whiteboardClient.setSelectedShape(ShapeEnum.Circle);
           // whiteboardClient.AddNewShape(ShapeEnum.Square);
        }
        else if(act.equals("Clear"))
        {
            whiteboardPannel.clearWhiteboard();
            //whiteboardClient.clearWhiteboard();
        }
    }

}
