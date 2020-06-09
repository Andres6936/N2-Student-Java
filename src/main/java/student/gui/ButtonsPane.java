package student.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Pane which contains the user interaction buttons
 */
public class ButtonsPane extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final String TEST = "TEST";

    private static final String COURSEREGISTRATION = "COURSE_REGISTRATION";

    private static final String GRADEREGISTRATION = "GRADE_REGISTRATION";

    private static final String OPTION1 = "OPTION_1";

    private static final String OPTION2 = "OPTION_2";

    private static final String COURSE_PENSUM = "COURSE_PENSUM";

    private static final String SEE = "SEE_COURSES";

    // -----------------------------------------------------------------
    // GUI Attributes
    // -----------------------------------------------------------------

    /**
     * Button to calculate the grades average
     */
    private JButton calculateButton;

    /**
     * Button to make a course registration
     */
    private JButton courseRegistrationButton;

    /**
     * Button to register a gradeB
     */
    private JButton gradeRegistrationButton;

    /**
     * Button for the extension point number 1
     */
    private JButton option1Button;

    /**
     * Button for the extension point number 2
     */
    private JButton option2Button;

    /**
     * Button to know if a course is in the pensum
     */
    private JButton subjectCoursedButton;

    /**
     * Button to see the courses list
     */
    private JButton seeCoursesButton;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Instance of the GUI's principal class
     */
    private StudentGUI father;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Creates the panel where all the buttons will be made at the GUI
     * @param theFather - instance of the containing pane - theFather !=null
     */
    public ButtonsPane( StudentGUI theFather )
    {
        father = theFather;
        // Button initialization
        calculateButton = new JButton( );

        courseRegistrationButton = new JButton( );

        gradeRegistrationButton = new JButton( );

        option1Button = new JButton( );
        option2Button = new JButton( );
        subjectCoursedButton = new JButton( );
        seeCoursesButton = new JButton( );

        initializeButtons( calculateButton, "Academic test period?", TEST, Color.BLACK, KeyEvent.VK_C );
        initializeButtons( courseRegistrationButton, "Course registration", COURSEREGISTRATION, Color.BLACK, KeyEvent.VK_N );
        initializeButtons( gradeRegistrationButton, "Grade registration", GRADEREGISTRATION, Color.BLACK, KeyEvent.VK_O );
        initializeButtons( option1Button, "Option 1", OPTION1, Color.BLACK, KeyEvent.VK_1 );
        initializeButtons( option2Button, "Option 2", OPTION2, Color.BLACK, KeyEvent.VK_2 );
        initializeButtons( subjectCoursedButton, "Is course in pensum?", COURSE_PENSUM, Color.BLACK, KeyEvent.VK_Y );
        initializeButtons( seeCoursesButton, "See Courses", SEE, Color.BLACK, KeyEvent.VK_V );
        setLayout( new GridLayout( 5, 2 ) );

        add( new JLabel( "" ) );// label to generate order in the Grid
        add( calculateButton );

        add( courseRegistrationButton );

        add( gradeRegistrationButton );
        add( subjectCoursedButton );
        add( seeCoursesButton );

        add( option1Button );
        add( option2Button );
        add( new JLabel( "" ) );// label to generate order in the Grid
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

        if( TEST.equals( actionCommand ) )
            father.studentInTest( );
        else if( COURSEREGISTRATION.equals( actionCommand ) )
            father.courseRegistration( );
        else if( GRADEREGISTRATION.equals( actionCommand ) )
            father.courseGradeRegistration( );
        else if( COURSE_PENSUM.equals( actionCommand ) )
            father.courseInPensum( );
        else if( SEE.equals( actionCommand ) )
            father.seeCourses( );
        else if( OPTION1.equals( actionCommand ) )
            father.reqFuncOpcion1( );
        else if( OPTION2.equals( actionCommand ) )
            father.reqFuncOpcion2( );

    }

}