package student.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Pane that creates the button for a course registration
 */
public class CourseRegistrationButtonsPane extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final String CANCEL = "CANCEL";

    private static final String ACCEPT = "ACCEPT";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Instance of the dialog to which it belongs
     */
    private final CourseRegistrationDialog father;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Creates the pane where the button to register the course is created
     * @param theFather - instance of the container dialog - theFather!=null
     */
    public CourseRegistrationButtonsPane( CourseRegistrationDialog theFather )
    {
        father = theFather;

        // Accept button
        JButton acceptButton = new JButton();

        // Cancel button
        JButton cancelButton = new JButton();

        initializeButtons(acceptButton, "Register", ACCEPT, Color.BLACK, KeyEvent.VK_E);
        initializeButtons(cancelButton, "Cancel", CANCEL, Color.BLACK, KeyEvent.VK_R);

        setLayout(new GridLayout(1, 2, 1, 8));

        // Add the buttons
        add(acceptButton);
        add(cancelButton);

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * Defines a button's properties. <br>
     * @param button - Button whose properties are going to be defined - button!=null
     * @param label - Button's presentation text- label!= null
     * @param command - Action associated to the button - command!= null
     * @param fontColor - Presentation text font's color - fontColor!= null
     * @param event - key event for the action of the button - event!=null
     */

    private void initializeButtons( JButton button, String label, String command, Color fontColor, int event )
    {

        button.setText( label );
        button.setFocusable( false );
        button.setActionCommand( command );
        button.addActionListener( this );
        button.setForeground( fontColor );
        button.setMnemonic( event );
        button.setDefaultCapable( false );

    }

    /**
     * Listener in charge of getting the events executed by the user. <br>
     * @param event - Event performed by the user - e!=null <br>
     */

    public void actionPerformed( ActionEvent event )
    {
        String actionCommand = event.getActionCommand( );

        if( ACCEPT.equals( actionCommand ) )
        {
            father.register( );

        }
        if( CANCEL.equals( actionCommand ) )
        {
            father.cancel( );

        }

    }

}