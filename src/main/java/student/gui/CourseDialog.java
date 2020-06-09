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
     * The pane used to contain the list
     */
    private JScrollPane displacementScroll;

    /**
     * List where courses are shown
     */
    private JList coursesList;

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
        displacementScroll = new JScrollPane( );

        // List where the courses will be contained
        coursesList = new JList( );
        coursesList.setSelectionMode( javax.swing.ListSelectionModel.SINGLE_SELECTION );

        // Scroll which will show the courses list
        displacementScroll.setVerticalScrollBarPolicy( javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        displacementScroll.setViewportView( coursesList );
        add( displacementScroll );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Modifies the courses list shown
     * @param courses the list with the courses that will be shown in the List
     */
    public void setListCourse( ArrayList courses )
    {
        coursesList.setListData( courses.toArray( ) );
    }

}
