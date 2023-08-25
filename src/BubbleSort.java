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
 * The BubbleSort class demonstrates the Bubble Sort algorithm for sorting arrays of strings
 * retrieved from CSV files. It measures and displays the number of executed statements for different
 * input sizes and arrangement variants, including best, worst, and average cases.
 */
 public class BubbleSort {
    /**
     * Main method initiates sorting and statement counting for various input sizes and arrangement variants.
     * @param args Command-line arguments
     */
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

        int sizeVariants = 5; // Number of different dataset sizes (10k, 50k, 200k, 500k, 1M)
        int arrangementVariants = 3;// Number of arrangement variants (Best, Worst, Average)

        // 2D array to store the results of statement counts
        long[][] results = new long[sizeVariants][arrangementVariants];

        // Call method to create a list of file paths for the datasets
        ArrayList<String> filePathInList= FilePathReader.createFilePathInList();;

        // Variable to track the current file number being processed
        int fileNumber = 0;

        // Nested loop to iterate through dataset sizes and arrangement variants
        for (int i = 0; i < sizeVariants; i++) {
            for (int j = 0; j < arrangementVariants; j++) {
                // Apply bubble sort and record statement counts
                results[i][j] = bubbleSort(filePathInList.get(fileNumber));
                fileNumber++;
                System.out.println("File: " + fileNumber);
            } // end of for
        } // end of for

        // Call the method to display the counts for all variants
        displayCounts(results);
    } // end of main method
    /**
     * Sorts the given array using the Bubble Sort algorithm.
     * @param fileName array of Strings to be sorted.
     * @return int count of statements executed in the method.
     */
    public static long bubbleSort(String fileName){
        /*
            ALGORITHM:
            1. Read data from the CSV file into an array.
            2. Initialize statementCount to 0.
            3. Iterate through the array using Bubble Sort algorithm
            4. Return the statementCount variable.
        */

        // Read data from the CSV file into an array
        String[] array = CSVReader.readDataFromFile(fileName);

        // Initialize statement count to track the number of executed statements
        long statementCount = 0;

        // Iterate through the array using Bubble Sort
        for (int i = 0; i<array.length-1; i++){
            statementCount += 4; // Increment for loop initialization and condition check
            for (int j = 0; j< array.length-i-1; j++){
                statementCount +=5; // Increment for loop initialization and condition check
                if (array[j].compareToIgnoreCase(array[j+1])>0){
                    statementCount+=2; // Increment for if condition
                    String temp = array[j];
                    statementCount++; // Increment for variable assignment
                    array[j] = array[j+1];
                    statementCount+=2; // Increment for variable assignment
                    array[j+1] = temp;
                    statementCount+=2; // Increment for variable assignment
                } // end of if
            } // end of for
        } // end of for
        // Return statement count
        return statementCount;
    } // end of bubbleSort method

    /**
     * Displays the sorting results for different cases.
     * @param results A 2D array containing sorting results for different dataset sizes and cases.
     * Each row corresponds to a dataset size, and columns correspond to best, worst, and average cases.
     */
    public static void displayCounts(long[][] results){
        // Define the labels for different data set sizes
        String[] sizes = {"10 thousand", "50 thousand", "200 thousand", "500 thousand", "1 million"};

        // Display header
        System.out.printf("%-40S%-30S%-30S%-30S","BUBBLE SORT RESULTS","BEST CASE","WORST CASE","AVERAGE CASE");
        System.out.println();

        // Display results for each dataset size
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.printf("%-40s%,-30d%,-30d%,-30d", sizes[i], results[i][j], results[i][j+1], results[i][j+2]);
                System.out.println();
            } // end of for
        } // end of for
    } // end of displayCounts method

} // end of BubbleSort class