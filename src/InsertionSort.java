/**
 * Group MixAndMatch
 * Class Code and Course Number: 9342 - CS 211
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     COLOMA, Stephen M.- 2232847@slu.edu.ph
 *     GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *     NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *     RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *     RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *     ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *     SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 * </p>
 */

import util.CSVReader;
import util.FilePathReader;

import java.util.ArrayList;

/**
 *  <p>
 *      The InsertionSort class provides an implementation of the Insertion Sort algorithm for sorting arrays
 *      of strings read from various CSV files. It includes functionality to sort data according to different
 *      size variants and arrangement types (Best, Worst, Average). The class also includes methods to create
 *      file paths, sort the data, and display the statement counts for different data sets.
 *  </p>
 */

public class InsertionSort {
    public static void main(String[] args) {
        /*ALGORITHM:
        * 1. Initiate the 2D array of length 5 by 3.
        * 2. The row will be the size variant (10k,50k,200k,500k,1M)
        * 3. The column will be the type arrangement variant (Best, Worst, Average)
        * 4. Create a list of strings that stores the file path above. Follow format BEST-WORST-AVERAGE
        * 5. Initiate variable int fileNumber = 0, it is the position of Best10k in the list
        * 6. Create a double for loop that populates the 2D array.
        * 7. Call the displayCount method and pass in the 2D array.
        * */

        int sizeVariants = 5; // Number of different sizes of datasets (e.g., 10k, 50k, 200k, 500k, 1M)
        int arrangementVariants = 3; // Number of arrangement variants (e.g., Best, Worst, Average)

        // 2D array to store the results of statement counts
        long[][] results = new long[sizeVariants][arrangementVariants];

        // Call method to create a list of file paths for the datasets
        ArrayList<String> filePathInList= FilePathReader.createFilePathInList();

        // Variable to track the current file number being processed
        int fileNumber = 0;

        // Nested loop to iterate through size and arrangement variants
        for (int i = 0; i < sizeVariants; i++) {
            for (int j = 0; j < arrangementVariants; j++) {
                // Apply insertion sort and record statement counts
                results[i][j] = insertionSort(filePathInList.get(fileNumber));
                fileNumber++;
                System.out.println("File: " + fileNumber);
            } // end of for
        } // end of for

        // Call the method to display the counts for all variants
        displayCounts(results);
    }//end of main method


    /**
     * Sorts the given array using the Insertion Sort algorithm.
     * @param filename name of file to be read.
     * @return int count of statements executed in the method.
     */
    public static long insertionSort(String filename) {
        /*
          ALGORITHM:
          1. Implement the Insertion Sort algorithm
          2. Initialize statementCount to 0;
          2. For every statement in the algorithm, increment the statementCount
          4. return statementCount variable
          */

        // Read the data from the CSV file into an array
        String[] arr = CSVReader.readDataFromFile(filename);

        // Initialize statement count to track the number of executed statements
        long statementCount=0;

        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            statementCount+=3;
            String key = arr[i]; // store the current value as the key
            statementCount++;
            int j = i - 1; // initialize the pointer for comparing with the key
            statementCount+=2;

            // Move elements that are greater than the key to one position ahead of their current position
            while (j >= 0 && arr[j].compareToIgnoreCase(key) > 0) {
                statementCount += 3;
                arr[j + 1] = arr[j]; // Shift the element
                statementCount+=2;
                j--; // Move to the previous element
                statementCount++;
            } // end of while

            // Place the key in its correct sorted position
            arr[j + 1] = key;
            statementCount+=2;
        } // end of for

        // Return the count of statements executed
        return statementCount;
    }// end of insertionSort method

    /**
     * Displays execution times for insertion sort in different cases and input sizes.
     * @param results a 2D array of execution times for insertion sort. The rows represent
     *                input sizes, while columns represent best, worst, and average cases.
     */
    public static void displayCounts(long[][] results) {
        // Define the labels for different data set sizes
        String[] sizes = {"10 thousand", "50 thousand", "200 thousand", "500 thousand", "1 million"};

        // Display header
        System.out.printf("%-40S%-30S%-30S%-30S","INSERTION SORT RESULTS","BEST CASE","WORST CASE","AVERAGE CASE");
        System.out.println();

        // Loop through the results array to display execution times for each data set size
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j<1; j++) {
                System.out.printf("%-40s%,-30d%,-30d%,-30d",sizes[i],results[i][j],results[i][j+1],results[i][j+2]);
                System.out.println();
            } // end of  inner loop
        } // end of outer loop
    }// end of displayCounts method

} // end of InsertionSort class

