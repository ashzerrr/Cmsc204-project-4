package pj4;


/**
 * @author Ashton kabou
 * 
 * CMSC 204
 * Assignment 4
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure CBS = new CourseDBStructure(20);

	
	/**
	 * Adds a new course to the CourseDBStructure.
	 *
	 *
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
	    CourseDBElement newCourse = new CourseDBElement(id, crn, credits, roomNum, instructor);
	    CBS.add(newCourse);
	}

	/**
	 * Retrieves a CourseDBElement based on the CRN key.
	 *
	 * @param crn course CRN (key)
	 * @return a CourseDBElement object if found, otherwise null
	 */
	@Override
	public CourseDBElement get(int crn) {
	    try {
	        return CBS.get(crn);
	    } catch (IOException e) {
	        System.out.println("IOException occurred: " + e.getMessage());
	    }
	    return null;
	}

	
		
	
	/**
	 * Reads the course information from a given input file and populates the CourseDBStructure.
	 *
	 * @param input the input file containing course information
	 * @throws FileNotFoundException if the input file is not found
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
	    try (Scanner scanner = new Scanner(input)) {
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parts = line.split(" ", 5);
	            if (parts.length == 5) {
	                String courseID = parts[0];
	                int CRN = Integer.parseInt(parts[1]);
	                int credits = Integer.parseInt(parts[2]);
	                String roomNum = parts[3];
	                String instructor = parts[4];
	                add(courseID, CRN, credits, roomNum, instructor);
	            }
	        }
	    }
	}


	/**
	 * Retrieves a list of string representations of all courses in the data structure.
	 * Each course representation is separated by a new line.
	 * @return an ArrayList of string representations of courses
	 */
	@Override
	public ArrayList<String> showAll() {
	    return CBS.showAll();
	}
}
	


