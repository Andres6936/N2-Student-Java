package main.java.student.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Pane used to calculate the average
 */
public class StudentDataPane extends JPanel
{

    // -----------------------------------------------------------------
    // GUI's attributes
    // -----------------------------------------------------------------

    /**
     * Grade's average label
     */
    private JLabel averageLabel;

    /**
     * Field where the grade's average is shown
     */
    private JTextField averageField;

    /**
     * Code Label
     */
    private JLabel codeLabel;

    /**
     * Field where the code is shown
     */
    private JTextField codeField;

    /**
     * Name label
     */
    private JLabel nameLabel;

    /**
     * Field where the name is shown
     */
    private JTextField nameField;

    /**
     * Last name label
     */
    private JLabel lastNameLabel;

    /**
     * Field where the last name is shown
     */
    private JTextField lastNameField;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Creates the pane where the objects to calculate the grade's average of a student will be organized
     */
    public StudentDataPane( )
    {
        setBorder( javax.swing.BorderFactory.createTitledBorder( null, "Student's Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null ) );
        setLayout( new GridLayout( 4, 2 ) );
        // Field where the student's code will be
        codeField = new JTextField( );
        codeField.setEditable( false );
        // Field where the student's grade's average will be
        averageField = new JTextField( );
        averageField.setEditable( false );
        // Field where the student's last name will be
        lastNameField = new JTextField( );
        lastNameField.setEditable( false );
        // Field where the student's name will be
        nameField = new JTextField( );
        nameField.setEditable( false );
        // Data register fields
        averageLabel = new JLabel( );
        codeLabel = new JLabel( );
        nameLabel = new JLabel( );
        lastNameLabel = new JLabel( );

        averageLabel.setText( "Grade's average" );
        codeLabel.setText( "Code" );
        nameLabel.setText( "Name" );
        lastNameLabel.setText( "Last name" );
        add( codeLabel );
        add( codeField );
        add( nameLabel );
        add( nameField );
        add( lastNameLabel );
        add( lastNameField );
        add( averageLabel );
        add( averageField );

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Changes the value of the averageField
     * @param value - Value that will have the averageField - value!=null <br>
     */

    public void setAverage( String value )
    {
        averageField.setText( value );
    }

    /**
     * Changes the value of the codeField
     * @param value - Value that will have the codeField - value!=null <br>
     */

    public void setCode( String value )
    {
        codeField.setText( value );
    }

    /**
     * Changes the value of the nameField
     * @param value - Value that will have the nameField - value!=null <br>
     */

    public void setNameUser( String value )
    {
        nameField.setText( value );
    }

    /**
     * Changes the value of the lastNameField
     * @param value - Value that will have the lastNameField - value!=null <br>
     */

    public void setLastName( String value )
    {
        lastNameField.setText( value );
    }

}