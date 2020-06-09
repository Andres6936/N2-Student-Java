package student.domain;

/**
 * Class modeling a student
 */
public class Student
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Student's code
     */
    private int code;

    /**
     * Student's name
     */
    private String name;

    /**
     * Student's last name
     */
    private String lastName;

    /**
     * Student's course
     */
    private Course course1;

    /**
     * Student's course
     */
    private Course course2;

    /**
     * Student's course
     */
    private Course course3;

    /**
     * Student's course
     */
    private Course course4;

    /**
     * Student's course
     */
    private Course course5;

    // -----------------------------------------------------------------
    // Constructor method
    // -----------------------------------------------------------------
    /**
     * A Student's Constructor method
     * @param theName - the student's name - theName != null
     * @param theLastName - the student's last name - theLastName != null
     * @param theCode - the student's code - theCode > -1
     */
    public Student( String theName, String theLastName, int theCode )
    {
        name = theName;
        lastName = theLastName;
        code = theCode;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * Method which assigns a course to a student. <br>
     * <b>post: </b> The student has a new course, if it is the fifth register, then the student cannot handle anymore. <br>
     * @param course to be asigned
     * @return true if it can assign the course and false if it is not possible.
     */
    public boolean assignCourse( Course course )
    {
        if( course1 == null )
        {
            course1 = course;

        }
        else if( course2 == null )
        {
            course2 = course;

        }
        else if( course3 == null )
        {
            course3 = course;

        }
        else if( course4 == null )
        {
            course4 = course;

        }
        else if( course5 == null )
        {
            course5 = course;

        }
        else
        {
            return false;
        }
        return true;
    }

    /**
     * Method calculating the student's grades average. <br>
     * <b>post: </b> Returned the Student's poundered grades average. <br>
     * @return gradesAverage - The average of the grades gotten by the student in the courses seen - gradesAverage >= 0.0
     */
    public double getStudentAverage( )
    {
        double course1Total = 0.0;
        double course2Total = 0.0;
        double course3Total = 0.0;
        double course4Total = 0.0;
        double course5Total = 0.0;
        double totalCredits = 0.0;
        double average = 0.0;
        if( course1 != null )
        {
            if( course1.getGrade( ) != 0.0 )
            {
                course1Total = course1.getGrade( ) * course1.getCredits( );
                totalCredits = totalCredits + course1.getCredits( );
            }

        }
        if( course2 != null )
        {
            if( course2.getGrade( ) != 0.0 )
            {
                course2Total = course2.getGrade( ) * course2.getCredits( );
                totalCredits = totalCredits + course2.getCredits( );
            }
        }
        if( course3 != null )
        {
            if( course3.getGrade( ) != 0.0 )
            {
                course3Total = course3.getGrade( ) * course3.getCredits( );
                totalCredits = totalCredits + course3.getCredits( );
            }
        }
        if( course4 != null )
        {
            if( course4.getGrade( ) != 0.0 )
            {
                course4Total = course4.getGrade( ) * course4.getCredits( );
                totalCredits = totalCredits + course4.getCredits( );
            }
        }
        if( course5 != null )
        {
            if( course5.getGrade( ) != 0.0 )
            {
                course5Total = course5.getGrade( ) * course5.getCredits( );
                totalCredits = totalCredits + course5.getCredits( );
            }
        }
        // It ensures that there will be not problem for having the denominator equal to 0.
        if( totalCredits > 0.0 )
        {
            average = ( course1Total + course2Total + course3Total + course4Total + course5Total ) / totalCredits;
        }

        return average;
    }

    /**
     * Method indicating if the student's pensum includes de course <br>
     * <b>post: </b> Returns true if  the student have seen the course or false if the student have not seen the course. <br>
     * @param courseCode - the code of the subject which we want to know if the student have coursed it - subjectCode != null
     * @return true if the student have seen the subject ( grade != 0.0 ), false if the student have not seen it
     */
    public boolean subjectInPensum( String courseCode )
    {
        Course aux = courseSearch( courseCode );
        if( aux != null )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Indicates if the student is in an academic test period. <br>
     * @return true if the student is in an academic test period, false if the student is not
     */
    public boolean studentInAcademicTestPeriod( )
    {
        double average = getStudentAverage( );
        if( average < 3.25 )
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * Indicates if the student has reached the maximum number of courses. <br>
     * <b>post: </b> Returns true if the student has all the courses assigned, false if not. <br>
     * @return Retorna true if the student has all the courses assigned, false if not
     */
    public boolean hasCompletedCourses( )
    {
        if( course1 == null || course2 == null || course3 == null || course4 == null || course5 == null )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * Method used to search for a course. <br>
     * <b>post: </b> Returns true if it is assigned to the student, false if not. <br>
     * @param courseCode - course's code of the course to be searched for - courseCode != null
     * @return Course if the course is assigned, null if not
     */
    public Course courseSearch( String courseCode )
    {
        if( course1 != null && course1.getCourseCode( ).equals( courseCode ) )
        {
            return course1;
        }
        else if( course2 != null && course2.getCourseCode( ).equals( courseCode ) )
        {
            return course2;
        }
        else if( course3 != null && course3.getCourseCode( ).equals( courseCode ) )
        {
            return course3;
        }
        else if( course4 != null && course4.getCourseCode( ).equals( courseCode ) )
        {
            return course4;
        }
        else if( course5 != null && course5.getCourseCode( ).equals( courseCode ) )
        {
            return course5;
        }
        else
        {
            return null;
        }
    }

    /**
     * Method which return the student's code
     * @return the student's code
     */
    public int getCode( )
    {
        return code;
    }

    /**
     * The method that returns the name of the student
     * @return student's name - name != null
     */
    public String getName( )
    {
        return name;
    }

    /**
     * The method that returns the student's last name
     * @return student's last name - lastName != null
     */
    public String getLastName( )
    {
        return lastName;
    }

    /**
     * The method that returns the student's course 1
     * @return Course course1
     */
    public Course getCourse1( )
    {
        return course1;
    }

    /**
     * The method that returns the student's course 2
     * @return Course course2
     */
    public Course getCourse2( )
    {
        return course2;
    }

    /**
     * The method that returns the student's course 3
     * @return Course course3
     */
    public Course getCourse3( )
    {
        return course3;
    }

    /**
     * The method that returns the student's course 4
     * @return Course course4
     */
    public Course getCourse4( )
    {
        return course4;
    }

    /**
     * The method that returns the student's course 5
     * @return Course course5
     */
    public Course getCourse5( )
    {
        return course5;
    }

    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    /**
     * Extension method
     * @return extension answer
     */
    public String method1( )
    {
        return "Answer number 1";
    }

    /**
     * Extension method
     * @return extension answer
     */
    public String method2( )
    {
        return "Answer number 2";
    }
}