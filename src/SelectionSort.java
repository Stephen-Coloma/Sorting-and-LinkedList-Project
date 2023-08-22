/**
 * Group MixAndMatch
 * Class Code and Course Number: 9342 - CS 211
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     STEPHEN M. COLOMA- 2232847@slu.edu.ph
 *     SANCHIE EARL M. GUZMAN- 2232886@slu.edu.ph
 *     MARIUS GLENN NONATO- 2232731@slu.edu.ph
 *     JERWIN KYLE R. RAMOS- 2232862@slu.edu.ph
 *     HANNAH T. RAGUDOS- 2233361@slu.edu.ph
 *     REY DANIEL L. ROQUE- 2233357@slu.edu.ph
 *     LOURDENE EIRA C. SANTOS- 2233120@slu.edu.ph
 * </p>
 *
 * <p>
 *     This class demonstrates the comparison of the Selection Sort algorithm
 *     with other sorting algorithms in terms of the number of statements executed.
 *     It reads data from input files, sorts the data using Selection Sort,
 *     and analyzes the number of statements executed for various input scenarios.
 * </p>
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Utility class to handle CSV operations
class CSVUtil {
    public static int[] readDataFromFile(String fileName) {
        List<Integer> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(Integer.parseInt(line));
            } // end of try
        } catch (IOException e) {
            e.printStackTrace();
        } // end of catch
        return dataList.stream().mapToInt(i -> i).toArray();
    } // end of readDataFromFile method
} // end of CSVUtil


public class SelectionSort {
    // TODO: Implement the methods on the main method
    public static void main(String[] args) {
    } // end of main method

    /**
     * Sorts the given array using the Selection Sort algorithm.
     * @param arr Array of integers to be sorted.
     */
    public static void selectionSort(int[] arr) {
        // TODO: Implement the Selection Sort algorithm
        // TODO: For every statement in the algorithm, increment the statementCount
        // TODO: Make sure to sort in ascending order
    } // end of selectionSort method

    /**
     * Shows the elements of the given array.
     * @param arr Array of integers.
     */
    public static void showElements(int[] arr) {
        // TODO: Implement printing array elements
    } // end of showElements method

    /**
     * Counts the number of statements executed during sorting.
     * @return Number of statements executed.
     */
    public static int countStatements() {
        // TODO: Return the total number of statements executed during sorting
        return 0;  // Placeholder return value
    } // end of countStatements method

    /**
     * Writes the given statement count to a results file.
     * @param statementCount Number of statements executed.
     */
    public static void writeResultsToFile(int statementCount) {
        // TODO: Implement writing the results (statement count) to a file
    } // end of writeResultsToFile method

} // end of SelectionSort class

