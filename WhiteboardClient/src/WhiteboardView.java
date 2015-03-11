import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by BLourence on 16/02/15.
 */
public class WhiteboardView implements ActionListener, ChangeListener
{
    private int size;

    private JButton clearBtn;
    private JButton circleBtn;
    private JButton triangleBtn;
    private JButton rectangleBtn;

    private JPanel panel1;
    private JPanel WhiteboardContainerPannel;
    private WhiteboardPanel whiteboardPannel;
    private JSpinner sizeSpinner;
    private JComboBox colourPicker;

    private WhiteboardClient whiteboardClient = null;


    public WhiteboardView()
    {
        //Button Listeners
        rectangleBtn.addActionListener(this);
        circleBtn.addActionListener(this);
        triangleBtn.addActionListener(this);
        clearBtn.addActionListener(this);


        colourPicker.addItem("Black");
        colourPicker.addItem("Red");
        colourPicker.addItem("Green");
        colourPicker.addItem("Blue");

        sizeSpinner.setValue(30);
        sizeSpinner.addChangeListener(this);

        colourPicker.addActionListener(this);

    }


    public void SetController(WhiteboardClient inputController)
    {
        whiteboardClient = inputController;
        whiteboardPannel.setWhiteboardClient(inputController);
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
            whiteboardClient.setSelectedShape(ShapeType.Rectanlge);
        }
        else if(act.equals("Triangle"))
        {
            whiteboardClient.setSelectedShape(ShapeType.Trianlge);
        }
        else if(act.equals("Circle"))
        {
            whiteboardClient.setSelectedShape(ShapeType.Circle);
        }
        else if(act.equals("Clear"))
        {
            whiteboardPannel.clearWhiteboard();
        }
        else if(act.equals("comboBoxChanged"))
        {
            String colStr = colourPicker.getSelectedItem().toString();

            whiteboardClient.setColour(assignColour(colStr));
        }
    }

    private Color assignColour(String colourString)
    {
        if(colourString.equals("Black"))
            return Color.black;
        else if(colourString.equals("Green"))
            return Color.green;
        else if(colourString.equals("Red"))
            return Color.red;
        else
            return Color.blue;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent)
    {
        whiteboardClient.setSize((Integer)sizeSpinner.getValue());
    }

    public void invokeRepaint()
    {
        whiteboardPannel.repaint();
    }
}
