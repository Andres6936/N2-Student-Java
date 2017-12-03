package edu.jabs.student.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Pane that assigns a grade to a course
 */
public class GradeRegistrationPane extends JPanel
{

    // -----------------------------------------------------------------
    // GIU's attributes
    // -----------------------------------------------------------------

    /**
     * Grade label
     */
    private JLabel gradeLabel;

    /**
     * Course's code label
     */
    private JLabel courseCodeLabel;

    /**
     * Field to show the grade
     */
    private JTextField noteField;

    /**
     * Field to show the course's code
     */
    private JTextField courseCodeField;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Creates the panel when the objects to assign the grade to a course will be organized
     */
    public GradeRegistrationPane( )
    {
        setBorder( javax.swing.BorderFactory.createTitledBorder( null, "Course's Grade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null ) );
        setLayout( new GridLayout( 4, 2 ) );
        // Field where the course's grade will go
        noteField = new JTextField( );
        // Field where the course's code will go
        courseCodeField = new JTextField( );

        // Data register fields
        courseCodeLabel = new JLabel( );
        gradeLabel = new JLabel( );

        gradeLabel.setText( "Grade" );

        courseCodeLabel.setText( "Course's code" );

        add( courseCodeLabel );
        add( courseCodeField );
        add( gradeLabel );
        add( noteField );

        add( new JLabel( "" ) );// label to generate order in the Grid

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Returns the course
     * @return course - course != null
     */
    public String getCourse( )
    {
        return courseCodeField.getText( );
    }

    /**
     * Returns the grade
     * @return grade - grade != null
     */
    public String getGrade( )
    {
        return noteField.getText( );
    }

    /**
     * Cleans the form
     */
    public void clean( )
    {
        noteField.setText( "" );
        courseCodeField.setText( "" );
    }
}