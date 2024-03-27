package pj4;


/**
 *
 * @author Ashton Kabou
 * @version Assignment 4
 * 
 */

public class CourseDBElement implements Comparable<CourseDBElement> {
    
    String courseID, roomNumber, instructor;
    int CRN, credits;
    
    /**
     * Constructs a CourseDBElement object with default values.
     */
    public CourseDBElement() {
        courseID = null;
        roomNumber = null;
        instructor = null;
        CRN = 0;
        credits = 0;
    }
    
    /**
     * Constructs a CourseDBElement object with the given parameters.
     * 
     * @param courseID   the course ID
     * @param CRN        the CRN (Course Registration Number)
     * @param credits   the number of credits
     * @param roomNumber      the room number
     * @param instructor the name of the instructor
     */
    public CourseDBElement(String courseID, int CRN, int credits, String roomN, String instructor) {
        this.courseID = courseID;
        this.roomNumber = roomN;
        this.instructor = instructor;
        this.CRN = CRN;
        this.credits = credits;
    }
    

    
    /**
     * Compares this CourseDBElement with another CourseDBElement to determine their equality.
     * 
     * @param o 
     * @return 0 if the elements are equal, 1 otherwise
     */
    
    
    @Override
    public int compareTo(CourseDBElement o) {
        return (this.courseID.equals(o.courseID) &&
                this.roomNumber.equals(o.roomNumber) &&
                this.instructor.equals(o.instructor) &&
                this.CRN == o.CRN && this.credits == o.credits) ? 0 : 1;
    }

   
    

    /**
     * Sets the CRN (Course Registration Number) of this CourseDBElement.
     * 
     * @param crn the CRN to be set
     */
    public void setCRN(int crn) {
        CRN = crn;
    }

    /**
     * Returns the room number of this CourseDBElement.
     * 
     * @return the room number
     */
    public String getRoomNum() {
        return roomNumber;
    }

    
    /**
     * Returns the course ID of this CourseDBElement.
     * 
     * @return the course ID
     */
    public String getID() {
        return courseID;
    }

    
        /**
     * Returns the CRN (Course Registration Number) of this CourseDBElement.
     * 
     * @return the CRN
     */
    public int getCRN() {
        return CRN;
    }
    
}


