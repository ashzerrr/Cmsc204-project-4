package pj4;

/**
 * @author Ashton Kabou
 * 
 * CMSC 204
 * assignment 4
 * 
 */


import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test class for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDBManagerTest_Student {

    private CourseDBManager manager = new CourseDBManager();
    
    /**
     * Create an instance of CourseDBManager
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        manager = new CourseDBManager();
    }

    /**
     * Set manager reference to null
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        manager = null;
    }

    /**
     * Test for the add method
     */
    @Test
    public void testAddToDB() {
        try {
            manager.add("PSY101", 34728, 3, "CS120", "Ashzerr Karl");
        }
        catch(Exception e) {
            fail("This should not have caused an Exception");
        }
    }
    
    /**
     * Test for the showAll method
     */
    
    @Test
    public void testShowAll() {
        manager.add("CMSC100", 21556, 2, "Distance-Learning", "Janet E. Joy");
        manager.add("CMSC100", 22344, 2, "SW217", "Gloria E. Barron");
        manager.add("CMSC100", 21561, 2, "SC451", "Rabiha J. Kayed");
        ArrayList<String> list = manager.showAll();
        assertEquals(list.get(0), "\nCourse:CMSC100 CRN:22344 Credits:2 Instructor:Gloria E. Barron Room:SW217");
        assertEquals(list.get(1), "\nCourse:CMSC100 CRN:21556 Credits:2 Instructor:Janet E. Joy Room:Distance-Learning");
        assertEquals(list.get(2), "\nCourse:CMSC100 CRN:21561 Credits:2 Instructor:Rabiha J. Kayed Room:SC451");
    }
    
    /**
     * Test for the read method
     */
    @Test
    public void testRead() {
        try {
            File inputFile = new File("Test1.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("Phy202 23467 4 SW255 Josh Ash");
            inFile.print("Psy102 32287 3 TH361 Tanner Donald");
            
            inFile.close();
            manager.readFile(inputFile);

        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }

}
