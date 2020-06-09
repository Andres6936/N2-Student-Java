package student.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Pane which contains the button for a grade allocation
 */
public class GradeRegistrationButtonsPane extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final String REGISTER = "GRADE_REGISTRATION";

    private static final String CANCEL = "CANCEL";

    // -----------------------------------------------------------------
    // GUI's attributes
    // -----------------------------------------------------------------

    /**
     * Button to register the grade
     */
    private JButton registerButton;

    /**
     * Button to cancel
     */
    private JButton cancelButton;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Instance of the Container Dialog Class
     */
    private CourseGradeDialog father;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Creates the pane where the grade registration button will be located
     * @param theFather - instance of the container dialog - theFather!=null
     */
    public GradeRegistrationButtonsPane( CourseGradeDialog theFather )
    {
        father = theFather;

        registerButton = new JButton( );
        cancelButton = new JButton( );

        initializeButtons( registerButton, "Grade Registration", REGISTER, Color.BLACK, KeyEvent.VK_A );
        initializeButtons( cancelButton, "Cancel", CANCEL, Color.BLACK, KeyEvent.VK_R );
        setLayout( new GridLayout( 1, 2, 1, 8 ) );

        // add the buttons
        add( registerButton );
        add( cancelButton );

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

        if( REGISTER.equals( actionCommand ) )
            father.courseGradeRegistration( );
        else if( CANCEL.equals( actionCommand ) )
            father.cancel( );
    }

}