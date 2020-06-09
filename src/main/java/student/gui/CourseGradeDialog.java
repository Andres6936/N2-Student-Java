package student.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import student.domain.Course;

/**
 * Dialog for a grade registration
 */
public class CourseGradeDialog extends JDialog
{
    // -----------------------------------------------------------------
    // Atributtes
    // -----------------------------------------------------------------
    /**
     * Instance of the GUI's principal class
     */
    private final StudentGUI father;

    /**
     * Graded course
     */
    private Course course;

    // -----------------------------------------------------------------
    // GUI's attributes
    // -----------------------------------------------------------------

    /**
     * The pane where the grade is registered
     */
    private final GradeRegistrationPane gradeRegistrationPane;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Creates the dialog where a grade's entry panel will be organized
     * @param theFather - instance of the containing pane - theFather!=null
     */
    public CourseGradeDialog( StudentGUI theFather )
    {
        // Saves the reference to the father
        father = theFather;
        course = null;

        // Dialog configuration
        setTitle("Grade Registration");
        setBackground(Color.white);
        setLayout(new BorderLayout());

        // Dialog panes
        gradeRegistrationPane = new GradeRegistrationPane();

        // The pane to control the dialog
        GradeRegistrationButtonsPane gradeRegistrationButtonPane = new GradeRegistrationButtonsPane(this);
        add(gradeRegistrationPane, BorderLayout.NORTH);
        add(gradeRegistrationButtonPane, BorderLayout.CENTER);
        setSize(300, 165);

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * Cleans the form
     */
    public void clean( )
    {
        gradeRegistrationPane.clean( );
    }

    /**
     * Cancels the register
     */
    public void cancel( )
    {
        dispose( );
    }

    /**
     * Returns a graded course
     * @return graded course
     */
    public Course getCourse( )
    {
        return course;
    }

    /**
     * Method that adds a grade to a course
     */
    public void courseGradeRegistration( )
    {
        String grade = gradeRegistrationPane.getGrade( );
        String code = gradeRegistrationPane.getCourse( );
        Course c;

        course = null;

        if( grade.equals( "" ) || code.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "You must fill all the fields", "Grade Registration", JOptionPane.ERROR_MESSAGE );
            return;
        }
        c = father.getStudent( ).courseSearch( code );
        if( c == null )
        {
            JOptionPane.showMessageDialog( this, "The course is not registrated", "Grade Registration", JOptionPane.ERROR_MESSAGE );
            return;
        }
        if( c.isGraded( ) )
        {
            JOptionPane.showMessageDialog( this, "The course already has a grade assigned to it", "Grade Registration", JOptionPane.ERROR_MESSAGE );
            return;
        }
        try
        {
            double courseGrade = Double.parseDouble( grade );

            if( courseGrade < 1.5 || courseGrade > 5.0 )
            {
                JOptionPane.showMessageDialog( this, "The grade must be between 1.5 and 5.0", "Grade Registration", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                course = new Course( code, "", 0 );
                course.assignGrade( courseGrade );
                dispose( );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "The grade's value must be a decimal number", "Grade Registration", JOptionPane.ERROR_MESSAGE );
        }

    }

}