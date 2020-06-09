package student.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import student.domain.Student;
import student.domain.Course;

/**
 * Main window of the Student's GUI
 */
public class StudentGUI extends JFrame
{

    // -----------------------------------------------------------------
    // GUI's attributes
    // -----------------------------------------------------------------

    /**
     * It is the pane where the data to register a student are collected
     */
    private StudentRegistrationPane studentRegistrationPane;

    /**
     * It is the pane where the data of the student are shown
     */
    private StudentDataPane studentDataPane;

    /**
     * It is the pane where the button to control the application are shown
     */
    private ButtonsPane buttonsPane;

    /**
     * The dialog used to show the courses
     */
    private CourseDialog courseDialog;

    /**
     * The dialog used to register a new course
     */
    private CourseRegistrationDialog courseRegistrationDialog;

    /**
     * The dialog used to register a course's grade
     */
    private CourseGradeDialog courseGradeDialog;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Attribute representing a student
     */
    private Student student;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Method that initializes every pane
     */
    public StudentGUI( )
    {
        // Configures border and background
        setLayout( new BorderLayout( ) );

        // Creates the panes and dialogs
        studentRegistrationPane = new StudentRegistrationPane( this );
        studentDataPane = new StudentDataPane( );
        buttonsPane = new ButtonsPane( this );

        // Course registration dialog
        courseRegistrationDialog = new CourseRegistrationDialog( );
        courseRegistrationDialog.setModal( true );

        // Dialog in which the courses are shown
        courseDialog = new CourseDialog( );
        courseDialog.setModal( true );

        // Course's grade dialog
        courseGradeDialog = new CourseGradeDialog( this );
        courseGradeDialog.setModal( true );

        add( studentRegistrationPane, BorderLayout.NORTH );
        add( studentDataPane, BorderLayout.CENTER );
        add( buttonsPane, BorderLayout.SOUTH );

        // Assign title, adjust the size and do not let it be modified
        setTitle( "Student" );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( javax.swing.JFrame.EXIT_ON_CLOSE );

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Register the student
     */
    public void studentRegistration( )
    {
        String code = studentRegistrationPane.getCode( );
        String name = studentRegistrationPane.getNameUser( );
        String lastName = studentRegistrationPane.getLastName( );

        try
        {
            if( name.equals( "" ) || code.equals( "" ) || lastName.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "You must fill all the fields", "Student Registration", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                student = new Student( name, lastName, Integer.parseInt( code ) );
                studentDataPane.setNameUser( student.getName( ) );
                studentDataPane.setLastName( student.getLastName( ) );
                studentDataPane.setCode( "" + student.getCode( ) );
                studentDataPane.setAverage( " " );
                JOptionPane.showMessageDialog( this, "Student registered", "Student registration", JOptionPane.INFORMATION_MESSAGE );
            }

        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "El valor del código debe ser numérico", "Registro estudiante", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Method that assigns a course to the student
     */
    public void courseRegistration( )
    {
        Course course;

        // Validates that ther is a student to which assign the courseValida que haya un estudiante a quien registrarle el curso
        if( student == null )
        {
            JOptionPane.showMessageDialog( this, "You must enter the student first", "Course Registration", JOptionPane.ERROR_MESSAGE );
        }
        // Validates that the student does not have the maximum number of courses assigned
        else if( student.hasCompletedCourses() )
        {
            JOptionPane.showMessageDialog( this, "The student courses are full", "Course Registration", JOptionPane.ERROR_MESSAGE );
            return;
        }
        else
        {
            // Presents the registrationDialog
            courseRegistrationDialog.clean( );
            courseRegistrationDialog.setLocation( calculatesCentralPosition( this, courseRegistrationDialog ) );
            courseRegistrationDialog.setVisible( true );

            // Takes the given course
            course = courseRegistrationDialog.getCourse( );

            // If it is null there is no assignment
            if( course == null )
            {
                return;
            }

            // If the course is already assigned
            if( student.subjectInPensum( course.getCourseCode( ) ) )
            {
                JOptionPane.showMessageDialog( this, "A course of code " + course.getCourseCode( ) + " has already been assigned", "Course Registration", JOptionPane.ERROR_MESSAGE );
                return;
            }
            student.assignCourse( course );
        }

    }

    /**
     * Assigns the grade of a course
     */
    public void courseGradeRegistration( )
    {

        if( student == null )
        {
            JOptionPane.showMessageDialog( this, "You must fill the student first", "Grade Registration", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            // Presents the dialog
            courseRegistrationDialog.clean( );
            courseGradeDialog.setLocation( calculatesCentralPosition( this, courseGradeDialog ) );
            courseGradeDialog.setVisible( true );

            // Takes the data of the course
            Course c = courseGradeDialog.getCourse( );

            // If the data is valid,  the grade registration process is done
            if( c != null )
            {
                Course course = student.courseSearch( c.getCourseCode( ) );
                course.assignGrade( c.getGrade( ) );

                double average = student.getStudentAverage( );
                studentDataPane.setAverage( String.valueOf( average ) );
            }
        }
    }

    /**
     * Indicates if the student is in academic test period or not
     */
    public void studentInTest( )
    {
        double average = 0.0;
        boolean inTest = false;

        if( student == null )
        {
            JOptionPane.showMessageDialog( this, "You must register the student first", "Grade's average calculus", JOptionPane.ERROR_MESSAGE );
        }
        else
        {

            average = student.getStudentAverage( );
            inTest = student.studentInAcademicTestPeriod( );

            if( average == 0.0 )
            {
                JOptionPane.showMessageDialog( this, "You must register at least one course's grade", "Grade's average calculus", JOptionPane.INFORMATION_MESSAGE );

            }
            else
            {
                if( inTest )
                {
                    JOptionPane.showMessageDialog( this, "The student is in academic test period, grade's average < 3.25", "Info", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "The student is not in academic test period, grade's average >= 3.25", "Info", JOptionPane.INFORMATION_MESSAGE );
                }
            }
        }

    }

    /**
     * Method that informs if a course have been already taken or not
     */
    public void courseInPensum( )
    {
        if( student == null )
        {
            JOptionPane.showMessageDialog( this, "You must register the student first", "Student Pensum", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            // Presents the dialog
            String code = JOptionPane.showInputDialog( this, "Código de curso", "Student Pensum", JOptionPane.QUESTION_MESSAGE );

            if( code != null && student.subjectInPensum( code ) )
            {
                JOptionPane.showMessageDialog( this, "The course " + code + " is included in the pensum", "Student Pensum", JOptionPane.INFORMATION_MESSAGE );
            }
            else if( code != null )
            {
                JOptionPane.showMessageDialog( this, "The course " + code + " is not included in the pensum", "Student Pensum", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }

    /**
     * Method used to see the registered courses
     */
    public void seeCourses( )
    {
        ArrayList courses = new ArrayList( );
        Course course = null;
        if( student != null )
        {
            course = student.getCourse1( );
            if( course != null )
            {
                courses.add( course.getDescription( ) );
            }
            course = student.getCourse2( );
            if( course != null )
            {
                courses.add( course.getDescription( ) );
            }
            course = student.getCourse3( );
            if( course != null )
            {
                courses.add( course.getDescription( ) );
            }
            course = student.getCourse4( );
            if( course != null )
            {
                courses.add( course.getDescription( ) );
            }
            course = student.getCourse5( );
            if( course != null )
            {
                courses.add( course.getDescription( ) );
            }
            courseDialog.setSize( 450, 200 );
            courseDialog.setListCourse( courses );
            courseDialog.setLocation( calculatesCentralPosition( this, courseDialog ) );
            courseDialog.setVisible( true );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "You must register a student first", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Calculates the point that indicates the frame's centered position
     * @param fatherComponent - Component's father window - !=null
     * @param sonComponent - Component's son window - !=null
     * @return point - Localization in coordinates x,y and the new component - !=null
     */
    private Point calculatesCentralPosition( Component fatherComponent, Component sonComponent )
    {
        Dimension screenSize;
        Dimension fatherSize, sonSize;
        Point fatherLocation;

        // Centers the window and verifies that it is not larger than the actual resolution
        screenSize = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int max_y = screenSize.height;
        int min_y = 0;

        // Screen resolution size
        fatherSize = fatherComponent.getSize( );
        fatherLocation = fatherComponent.getLocation( );
        sonSize = sonComponent.getSize( );
        int x = ( fatherSize.width - sonSize.width ) / 2 + fatherLocation.x;
        int y = ( fatherSize.height - sonSize.height ) / 2 + fatherLocation.y;

        // Setting down
        if( y + sonSize.height > max_y )
        {
            y = max_y - sonSize.height;
        }

        // Setting up
        if( y < min_y )
        {
            y = 0;
        }
        return new Point( x, y );
    }

    /**
     * Method that return a student's instance
     * @return student - a student instance - student != null
     */
    public Student getStudent( )
    {
        return student;

    }

    // -----------------------------------------------------------------
    // Extension Points
    // -----------------------------------------------------------------

    /**
     * Extension's option 1
     */
    public void reqFuncOpcion1( )
    {
        if( student != null )
        {
            String answer = student.method1( );
            JOptionPane.showMessageDialog( this, answer, "Answer", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "You must register a student first", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Extension's option 2
     */
    public void reqFuncOpcion2( )
    {
        if( student != null )
        {
            String answer = student.method2( );
            JOptionPane.showMessageDialog( this, answer, "Answer", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "You must register a student firs", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Principal execution method
     * @param args - Execution entry arguments. The must not be used.
     */
    public static void main( String[] args )
    {
        StudentGUI i = new StudentGUI( );
        i.setVisible( true );
    }
}