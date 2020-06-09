package student.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import student.domain.Course;

/**
 * Dialog for a course registration
 */
public class CourseRegistrationDialog extends JDialog
{
    // -----------------------------------------------------------------
    // GUI's attribute
    // -----------------------------------------------------------------

    /**
     * Register form
     */
    private CourseRegistrationPane courseRegistrationPane;

    /**
     * Register buttons
     */
    private CourseRegistrationButtonsPane courseRegistrationButtonsPane;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Course to be registered
     */
    private Course course;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Creates the dialog where the course registration panes will be organized
     */
    public CourseRegistrationDialog( )
    {

        setTitle( "Course Registration" );
        setBackground( Color.white );
        setLayout( new BorderLayout( ) );
        courseRegistrationPane = new CourseRegistrationPane( );
        courseRegistrationButtonsPane = new CourseRegistrationButtonsPane( this );
        add( courseRegistrationPane, BorderLayout.CENTER );
        add( courseRegistrationButtonsPane, BorderLayout.SOUTH );
        setSize( 250, 250 );
        course = null;

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * Returns the course that will be registered
     * @return course to register
     */
    public Course getCourse( )
    {
        return course;
    }

    /**
     * Cleans the form
     */
    public void clean( )
    {
        courseRegistrationPane.clean( );
    }

    /**
     * The action of registering a course
     */
    public void register( )
    {
        String courseName = courseRegistrationPane.getNameUser( );
        String courseCode = courseRegistrationPane.getCode( );
        String courseCredits = courseRegistrationPane.getCredits( );
        course = null;
        int credits;

        if( courseName.equals( "" ) || courseCode.equals( "" ) || courseCredits.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "You must fill all the fields", "Course Registration", JOptionPane.ERROR_MESSAGE );
            return;
        }

        try
        {
            credits = Integer.parseInt( courseCredits );
            if( credits < 0 )
            {
                JOptionPane.showMessageDialog( this, "The credits must be greater than or equal to zero (0)", "Course Registration", JOptionPane.ERROR_MESSAGE );
                return;
            }

            // If the data is complete a course is created to be returned
            course = new Course( courseCode, courseName, credits );
            dispose( );
        }
        catch( Exception e )
        {

            JOptionPane.showMessageDialog( this, "The value of the credits must be numeric", "Course Registration", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Cancels the register
     */
    public void cancel( )
    {
        course = null;
        dispose( );
    }
}