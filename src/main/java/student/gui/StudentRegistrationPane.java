package student.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Pane managing student's data
 */
public class StudentRegistrationPane extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final String ENTER = "ENTER";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Instancia del la clase principal de la interfaz
     */
    private StudentGUI father;

    // -----------------------------------------------------------------
    // GUI's attributes
    // -----------------------------------------------------------------

    /**
     * Name label
     */
    private JLabel nameLabel;

    /**
     * Last name label
     */
    private JLabel lastNameLabel;

    /**
     * Code label
     */
    private JLabel codeLabel;

    /**
     * Last name field
     */
    private JTextField lastNameTextField;

    /**
     * Name field
     */
    private JTextField nameField;

    /**
     * Code field
     */
    private JTextField codeField;

    /**
     * Button to register the student
     */
    private JButton enterButton;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Creates the pane where the objects to register a student will be organized
     * @param principalWindow - GUI's principal window - principalWindow != null
     */
    public StudentRegistrationPane( StudentGUI principalWindow )
    {
        // Saves the reference to the principal window
        father = principalWindow;

        // Sets the color, border and layout
        setBorder( javax.swing.BorderFactory.createTitledBorder( null, "Student Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null ) );
        setLayout( new GridLayout( 2, 4, 5, 5 ) );

        // Student basic data
        nameField = new JTextField( );
        lastNameTextField = new JTextField( );
        codeField = new JTextField( );
        nameLabel = new JLabel( "Name" );
        lastNameLabel = new JLabel( "Last name" );
        codeLabel = new JLabel( "Code" );

        // Registration button
        enterButton = new JButton( "Register" );
        enterButton.setActionCommand( ENTER );
        enterButton.addActionListener( this );

        add( nameLabel );
        add( nameField );
        add( lastNameLabel );
        add( lastNameTextField );
        add( codeLabel );
        add( codeField );
        add( new JLabel( "" ) );
        add( enterButton );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Returns the name of the student
     * @return name of the student - name != null
     */

    public String getNameUser( )
    {
        return nameField.getText( );
    }

    /**
     * Returns student's last name
     * @return student's last name - lastName != null
     */

    public String getLastName( )
    {
        return lastNameTextField.getText( );
    }

    /**
     * Returns the student's code
     * @return student's code
     */

    public String getCode( )
    {
        return codeField.getText( );

    }

    /**
     * Answer to the GUI's events <br>
     * @param event generated by the user - event !=null <br>
     */

    public void actionPerformed( ActionEvent event )
    {
        String actionCommand = event.getActionCommand( );

        if( ENTER.equals( actionCommand ) )
            father.studentRegistration( );

    }
}