package student.gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Dialog to show the subjects coursed
 */
public class CourseDialog extends JDialog
{

    // -----------------------------------------------------------------
    // GUI's attributes
    // -----------------------------------------------------------------

    /**
     * List where courses are shown
     */
    private final JList<String> coursesList;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Dialog where the registered courses are shown
     */
    public CourseDialog( )
    {
        setBackground( Color.white );
        setTitle( "Courses" );

        // The pane used to contain the list
        JScrollPane displacementScroll = new JScrollPane();

        // List where the courses will be contained
        coursesList = new JList<>( );
        coursesList.setSelectionMode( javax.swing.ListSelectionModel.SINGLE_SELECTION );

        // Scroll which will show the courses list
        displacementScroll.setVerticalScrollBarPolicy( javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        displacementScroll.setViewportView( coursesList );
        add(displacementScroll);
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Modifies the courses list shown
     *
     * @param courses the list with the courses that will be shown in the List
     */
    public void setListCourse(ArrayList<String> courses)
    {
        coursesList.setListData((String[])courses.toArray());
    }

}
