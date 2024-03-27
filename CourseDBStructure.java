package pj4;


/**
 * @author Ashton Kabou
 * 
 * CMSC 204
 * Assignment 4
 * 
 */



import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

    private ArrayList<LinkedList<CourseDBElement>> hashMap;
    private int size;
    private final double LoadingFactor = 1.5;

    /**
     * Checks whether the given number is prime.
     *
     * @param n The number to be checked
     * @return true if n is prime, false otherwise
     */
    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
            i += 6;
        }
        return true;
    }

    /**
     * Calculates the next prime number of the form 4k+3 after n.
     *
     * @param n The number to calculate the next prime from
     * @return The next prime number of the form 4k+3 after n
     */
    private int f4kP3Prime(int n) {
        int nextPrime = (int) (n / LoadingFactor) + 1;
        if (nextPrime % 2 == 0) // Ensure the next prime starts from an odd number
            nextPrime++;
        while (true) {
            if (isPrime(nextPrime) && (nextPrime - 3) % 4 == 0)
                return nextPrime;
            nextPrime += 2; // Skip even numbers, as they cannot be prime (except 2)
        }
    }

    /**
     * Constructs a CourseDBStructure with the estimated number of elements.
     *
     * @param n The estimated number of elements
     */
    public CourseDBStructure(int n) {
        size = f4kP3Prime(n);
        hashMap = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            hashMap.add(new LinkedList<>());
        }
    }

    /**
     * Constructs a CourseDBStructure with the specified size (for testing purposes).
     *
     * @param n The size of the CourseDBStructure
     * @param testing For testing purposes only
     */
    public CourseDBStructure(String testing, int n) {
        size = n;
        hashMap = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            hashMap.add(new LinkedList<>());
        }
    }

    /**
     * Adds a CourseDBElement to the CourseDBStructure.
     *
     * @param element The CourseDBElement to be added
     */
    @Override
    public void add(CourseDBElement element) {
        int index = element.getCRN() % size;
        LinkedList<CourseDBElement> bucket = hashMap.get(index);
        if (bucket.isEmpty()) {
            bucket.add(element);
        } else {
            boolean found = false;
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).getCRN() == element.getCRN()) {
                    bucket.set(i, element);
                    found = true;
                    break;
                }
            }
            if (!found) {
                bucket.add(element);
            }
        }
        hashMap.set(index, bucket);
    }

    /**
     * Retrieves a CourseDBElement based on the given CRN (key).
     *
     * @param crn The CRN to search for
     * @return The CourseDBElement with the given CRN
     * @throws IOException if the CRN is not found
     */
    
    @Override
    public CourseDBElement get(int crn) throws IOException {
        int index = crn % hashMap.size();
        LinkedList<CourseDBElement> bucket = hashMap.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getCRN() == crn) {
                return bucket.get(i);
            }
        }
        throw new IOException("CRN not found");
    }

    /**
     * Returns an ArrayList containing string representations of each course in the data structure.
     *
     * @return An ArrayList of string representations of courses
     */
   
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> courses = new ArrayList<>();
        for (int i = 0; i < hashMap.size(); i++) {
            LinkedList<CourseDBElement> bucket = hashMap.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                CourseDBElement element = bucket.get(j);
                String str = "\nCourse:" + element.courseID + " CRN:" +
                        element.CRN + " Credits:" + element.credits +
                        " Instructor:" + element.instructor +
                        " Room:" + element.roomNumber;
                courses.add(str);
            }
        }
        return courses;
    }

    /**
     * Returns the size of the CourseDBStructure (number of indexes in the array).
     *
     * @return The size of the CourseDBStructure
     */
    @Override
    public int getTableSize() {
        return size;
    }
}
