import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by BLourence on 16/02/15.
 *
 * WhiteboardView the source file accompaniment to WhiteboardView.form
 *
 * updateClientInfo() updates JLabels displaying client information with data
 * retrieved from the server.
 *
 * assignColour(string colourString) returns Color(awt) for new shapes.
 *
 * setController(WhiteboardClient inputController) assigns a references to the whiteboardClient
 * in order to invoke methods from actions on the view.
 *
 * showForm() packs and displays the view to the user.
 *
 * invokeRepaint() updates client information by calling updateClientInfo() and repaints shapes
 * in the custom whiteboardPanel.
 *
 * actionPerformed(ActionEvent actionEvent) captures events in the view such as selecting a new shape,
 * clearing the whiteboard or colour combo box being updated.
 *
 * stateChanged(ChangeEvent changeEvent) captures when the size has been altered from the view.
 */
public class WhiteboardView implements ActionListener, ChangeListener
{
    private JButton clearBtn;
    private JButton circleBtn;
    private JButton triangleBtn;
    private JButton squareBtn;
    private JPanel panel1;
    private JPanel WhiteboardContainerPanel;
    private WhiteboardPanel whiteboardPanel;
    private JSpinner sizeSpinner;
    private JComboBox colourPicker;
    private JLabel connectedClientsLbl;
    private JLabel clientNumberLbl;
    private WhiteboardClient whiteboardClient = null;

    //Constructor
    public WhiteboardView()
    {
        squareBtn.addActionListener(this);
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

    private void updateClientInfo()
    {
        String connectedClientsStr = whiteboardClient.getConnectedClients() + "";
        String clientNumberStr = whiteboardClient.getClientNumber() + "";

        connectedClientsLbl.setText(connectedClientsStr);
        clientNumberLbl.setText(clientNumberStr);
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

    public void setController(WhiteboardClient inputController)
    {
        whiteboardClient = inputController;
        whiteboardPanel.setWhiteboardClient(inputController);
        updateClientInfo();
    }
    public void showForm()
    {
        JFrame frame = new JFrame("Whiteboard");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(700,450);

        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing (WindowEvent we)
            {
                whiteboardClient.deregisterClient();
                System.exit(0);
            }
        });
    }
    public void invokeRepaint()
    {
        updateClientInfo();
        whiteboardPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String act = actionEvent.getActionCommand();
        if(act.equals("Square"))
        {
            whiteboardClient.setSelectedShape(ShapeType.Square);
        }
        else if(act.equals("Triangle"))
        {
            whiteboardClient.setSelectedShape(ShapeType.Triangle);
        }
        else if(act.equals("Circle"))
        {
            whiteboardClient.setSelectedShape(ShapeType.Circle);
        }
        else if(act.equals("Clear"))
        {
            whiteboardPanel.clearWhiteboard();
        }
        else if(act.equals("comboBoxChanged"))
        {
            String colStr = colourPicker.getSelectedItem().toString();

            whiteboardClient.setColour(assignColour(colStr));
        }
    }
    @Override
    public void stateChanged(ChangeEvent changeEvent)
    {
        whiteboardClient.setSize((Integer)sizeSpinner.getValue());
    }
}
