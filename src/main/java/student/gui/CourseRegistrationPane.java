package student.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Pane managing a course registration
 */
public class CourseRegistrationPane extends JPanel
{

    // -----------------------------------------------------------------
    // GUI's attributes
    // -----------------------------------------------------------------

    /**
     * Field for the name
     */
    private final JTextField nameField;

    /**
     * Field for the number of credits
     */
    private final JTextField creditsField;

    /**
     * Field for the code of the course
     */
    private final JTextField courseCodeField;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Creates the Pane in which the objects to registrate a course to the student will be organized
     */
    public CourseRegistrationPane( )
    {
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
        setLayout(new GridLayout(5, 0));
        // Field where the course's name will be
        nameField = new JTextField();
        // Field for the course's code
        courseCodeField = new JTextField();
        // Field for the course's credits
        creditsField = new JTextField();
        // Fields for the data registration

        // Course's Code Label
        JLabel courseCodeLabel = new JLabel();
        // Name's Label
        JLabel nameLabel = new JLabel();
        // Credits' Label
        JLabel creditsLabel = new JLabel();

        nameLabel.setText("Name");

        courseCodeLabel.setText("Course's code");

        creditsLabel.setText("Credits");

        add(nameLabel);
        add(nameField);
        add(courseCodeLabel);
        add(courseCodeField);
        add(creditsLabel);
        add(creditsField);

        add(new JLabel(""));// label to generate order in the grid
        add(new JLabel(""));// label to generate order in the grid
        add(new JLabel(""));// label to generate order in the grid
        add(new JLabel(""));// label to generate order in the grid
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Returns the course's code
     * @return course's code
     */
    public String getCode( )
    {
        return courseCodeField.getText( );
    }

    /**
     * Return the course's name
     * @return course's name
     */
    public String getNameUser( )
    {
        return nameField.getText( );
    }

    /**
     * Return course's credits
     * @return credits
     */
    public String getCredits( )
    {
        return creditsField.getText( );
    }

    /**
     * Cleans the form
     */
    public void clean( )
    {
        nameField.setText( "" );
        creditsField.setText( "" );
        courseCodeField.setText( "" );
    }

}