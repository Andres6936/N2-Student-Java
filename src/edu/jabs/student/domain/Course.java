package edu.jabs.student.domain;

/**
 * Class modeling a course
 */
public class Course
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Course's code
     */
    private String courseCode;

    /**
     * Course's name
     */
    private String courseName;

    /**
     * Course's number of credits
     */
    private int credits;

    /**
     * Course's grade
     */
    private double grade;

    // -----------------------------------------------------------------
    // Constructor methods
    // -----------------------------------------------------------------
    /**
     * Course's constructor method
     * @param nCourseCode - course's code - nCourseCode - != null
     * @param nCourseName - course's name - nCourseName - != null
     * @param nCourseCredits - nCourseCredits - >= -1
     */
    public Course( String nCourseCode, String nCourseName, int nCourseCredits )
    {
        grade = 0.0;
        credits = nCourseCredits;
        courseName = nCourseName;
        courseCode = nCourseCode;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * Returns the subject number of credits
     * @return credits - Returns the number of credits - credits >= 0
     */
    public int getCredits( )
    {
        return credits;
    }

    /**
     * Assigns the number of credits for the new course
     * @param newCredits - new value for credits - newCredits >0
     */
    public void assignCredits( int newCredits )
    {
        credits = newCredits;
    }

    /**
     * Returns the course's grade
     * @return grade - returns the course's grade - grade >=0.0
     */
    public double getGrade( )
    {
        return grade;
    }

    /**
     * Assigns the grade to the course. <br>
     * <b>post: </b> A grade is assigned to the course. The grade cannot be less than 1.5
     * @param newGrade - the course's grade - newGrade >= 1.5
     */
    public void assignGrade( double newGrade )
    {
        grade = newGrade;
    }

    /**
     * Method that return the course's name
     * @return courseName - course's name - courseName != null
     */
    public String getCourseName( )
    {
        return courseName;
    }

    /**
     * Method that returns the code of the course
     * @return courseCode - course's code - courseCode != null
     */
    public String getCourseCode( )
    {
        return courseCode;
    }

    /**
     * Delivers the course information
     * @return Course's description
     */
    public String getDescription( )
    {
        return "Name: " + courseName + "     Code: " + courseCode + "     Credits:" + credits;

    }

    /**
     * Indicates if a grade has already been assigned to the course. <br>
     * <b>post: </b> Returns true if the course has, already, a grade assigned to it. <br>
     * @return true if the course has a grade assigned to it, false if not
     */
    public boolean isGraded( )
    {
        if( grade == 0.0 )
            return false;
        else
            return true;
    }
}
