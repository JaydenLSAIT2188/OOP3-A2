package tests;

import utilities.MyArrayList;

/**
 * Test class for MyArrayList.
 * This class contains various test cases to verify the functionality of MyArrayList.
 */
/**
 * @author Isaac, David, Jayden
 * */

public class MyArrayListTest {

    /**
     * Main method to run the test cases.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        boolean testPassed;

        // Test adding and getting elements
        list.add(1);
        list.add(2);
        testPassed = list.get(0).equals(1) && list.get(1).equals(2);
        System.out.println("Test add and get: " + (testPassed ? "PASSED" : "FAILED"));

        // Test removing elements
        list.remove(0); // Remove first element
        testPassed = list.get(0).equals(2) && list.size() == 1;
        System.out.println("Test remove: " + (testPassed ? "PASSED" : "FAILED"));

        // Test size
        testPassed = list.size() == 1;
        System.out.println("Test size: " + (testPassed ? "PASSED" : "FAILED"));

        // Test isEmpty on non-empty list
        testPassed = !list.isEmpty();
        System.out.println("Test isEmpty on non-empty list: " + (testPassed ? "PASSED" : "FAILED"));

        // Test set
        list.set(0, 3); // Set first element to 3
        testPassed = list.get(0).equals(3);
        System.out.println("Test set: " + (testPassed ? "PASSED" : "FAILED"));

        // Test clear
        list.clear();
        testPassed = list.isEmpty();
        System.out.println("Test clear: " + (testPassed ? "PASSED" : "FAILED"));

        // Test isEmpty on empty list
        testPassed = list.isEmpty();
        System.out.println("Test isEmpty on empty list: " + (testPassed ? "PASSED" : "FAILED"));

        // Test adding after clear
        list.add(4);
        testPassed = list.get(0).equals(4) && list.size() == 1;
        System.out.println("Test add after clear: " + (testPassed ? "PASSED" : "FAILED"));

        // Test removing from empty list
        try {
            list.clear();
            list.remove(0);
            System.out.println("Test remove from empty list: FAILED");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Test remove from empty list: PASSED");
        }

        // Test getting from empty list
        try {
            list.clear();
            list.get(0);
            System.out.println("Test get from empty list: FAILED");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Test get from empty list: PASSED");
        }

        // Test set on empty list
        try {
            list.clear();
            list.set(0, 5);
            System.out.println("Test set on empty list: FAILED");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Test set on empty list: PASSED");
        }
    }
}
