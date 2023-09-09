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

import util.CSVReader;       // Importing CSVReader utility for reading data from CSV files
import util.FilePathReader;  // Importing FilePathReader utility for managing file paths
import java.util.ArrayList;  // Importing ArrayList class for creating dynamic lists

/**
 * The SelectionSort class implements the Selection Sort algorithm to sort arrays of strings
 * representing data from CSV files. It measures and displays the number of executed statements
 * for different input sizes and arrangement variants (best, worst, and average cases).
 * The class includes methods for sorting, counting statements, and displaying results.
 */
public class SelectionSort {
    /**
     * Main method initiates sorting and statement counting for various input sizes and arrangement variants.
     * @param args Command-line arguments
     */

    public static void main(String[] args) {
/*
        ALGORITHM:
        1. Initiate the 2D array of length 5 by 3.
        2. The row will be the size variant (10k,50k,200k,500k,1M)
        3. The column will be the type arrangement variant (Best, Worst, Average)
        4. Create a list of strings that stores the file path above. Follow format BEST-WORST-AVERAGE
        5. Initiate variable int fileNumber = 0, it is the position of Best10k in the list
        6. Create a double for loop that populates the 2D array.
        7. Call the displayCount method and pass in the 2D array.
    */
        int sizeVariants = 5;
        int arrangementVariants = 3;

        // 2D array to store statement counts
        long[][] results = new long[sizeVariants][arrangementVariants];


        ArrayList<String> filePathInList= FilePathReader.createFilePathInList();

        // Variable to track the current file number being processed
        int fileNumber = 0;

        for (int i = 0; i < sizeVariants; i++) {
            for (int j = 0; j < arrangementVariants; j++) {
                results[i][j] = selectionSort(filePathInList.get(fileNumber));
                fileNumber++;
                System.out.println("File: " + fileNumber);
            }
        }

        displayCounts(results);
    }

    /**
     * Sorts the given array using the Selection Sort algorithm.
     * @param fileName Array of Strings to be sorted.
     * @return int count of statements executed in the method.
     */
    /*
        ALGORITHM:
        1. Read data from the CSV file into an array.
        2. Initialize statementCount to 0.
        3. Iterate through the array using Selection Sort algorithm
        4. Return the statementCount variable.
    */
    public static long selectionSort(String fileName) {
        // Read the data from the CSV file into an array
        String[] array = CSVReader.readDataFromFile(fileName);

        // Initialize statement count to track executed statements
        long statementCount = 0;

        // Iterate through the array to sort it using Selection Sort algorithm
        for(int i=0; i < array.length-1; i++){
            int minIndex = i;
            statementCount++;

            // Iterate through the unsorted part of the array to find the minimum element
            for (int j=i+1; j < array.length; j++){
                if (array[j].compareToIgnoreCase(array[minIndex]) < 0) {
                    statementCount ++;
                    minIndex = j;
                    statementCount++;
                }
                statementCount += 2; //iterative count to for
            }
            statementCount += 3; //count to falsy for
            // Swap the found minimum element with the first element in the unsorted part
            String temp = array[minIndex];
            statementCount++;
            array [minIndex] = array[i];
            statementCount ++;
            array[i] = temp;
            statementCount++;

            statementCount+=3; //iterative count to for
        }//end of for
        statementCount+=3; //count for falsy for
        return ++statementCount;
    }

    /**
     * Displays execution times for insertion sort in different cases and input sizes.
     * @param results a 2D array of execution times for insertion sort. The rows represent
     *                input sizes, while columns represent best, worst, and average cases.
     */
    public static void displayCounts(long[][] results){
        /*
        ALGORITHM:
        1. Define labels for different data set sizes.
        2. Display a header with appropriate formatting.
        3. Loop through the results array to display execution times for each dataset size.
            - For each dataset size, display the execution times for best, worst, and average cases.
    */

        // Define the labels for different data set sizes
        String[] sizes = {"10 thousand", "50 thousand", "200 thousand", "500 thousand", "1 million"};

        // Display header
        System.out.printf("%-40S%-30S%-30S%-30S","SELECTION SORT RESULTS","BEST CASE","WORST CASE","AVERAGE CASE");
        System.out.println();

        // Loop through results array and display execution times
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j<1; j++) {
                System.out.printf("%-40s%,-30d%,-30d%,-30d",sizes[i],results[i][j],results[i][j+1],results[i][j+2]);
                System.out.println();
            }
        }
    }
}