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
import java.util.ArrayList;

public class SelectionSort {
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
        int arrangementVariants = 3; // Number of arrangement variants (Best, Worst, Average)

        // 2D array to store statement counts
        long[][] results = new long[sizeVariants][arrangementVariants];

        // Call method to create a list of file paths for the datasets
        ArrayList<String> filePathInList= createFilePathInList();

        // Variable to track the current file number being processed
        int fileNumber = 0;

        // Nested loop to iterate through size and arrangement variants
        for (int i = 0; i < sizeVariants; i++) {
            for (int j = 0; j < arrangementVariants; j++) {
                // Apply selection sort and record statement counts
                results[i][j] = selectionSort(filePathInList.get(fileNumber));
                fileNumber++;
                System.out.println("File: " + fileNumber);
            } // end of inner for loop
        } // end of outer for loop

        // Call the method to display the counts for all variants
        displayCounts(results);
    } // end of main method


    /**
     * Creates file paths for the datasets.
     * Adds these files to the ArrayList.
     * @return the ArrayList containing the file paths.
     */
    private static ArrayList<String> createFilePathInList() {
        // File paths for 10K dataset cases
        String Best10K = "src/dataset/TenThousand/10K-BestCase.csv";
        String Worst10K = "src/dataset/TenThousand/10K-WorstCase.csv";
        String Avg10K = "src/dataset/TenThousand/10K-AverageCase.csv";

        // File paths for 50K dataset cases
        String Best50K = "src/dataset/FiftyThousand/50K-BestCase.csv";
        String Worst50K = "src/dataset/FiftyThousand/50K-WorstCase.csv";
        String Avg50K = "src/dataset/FiftyThousand/50K-AverageCase.csv";

        // File paths for 200K dataset cases
        String Best200K = "src/dataset/TwoHundredThousand/200K-BestCase.csv";
        String Worst200K = "src/dataset/TwoHundredThousand/200K-WorstCase.csv";
        String Avg200K = "src/dataset/TwoHundredThousand/200K-AverageCase.csv";

        // File paths for 500K dataset cases
        String Best500K = "src/dataset/FiveHundredThousand/500K-BestCase.csv";
        String Worst500K = "src/dataset/FiveHundredThousand/500K-WorstCase.csv";
        String Avg500K = "src/dataset/FiveHundredThousand/500K-AverageCase.csv";

        // File paths for 1M dataset cases
        String Best1M = "src/dataset/OneMillion/1M-BestCase.csv";
        String Worst1M = "src/dataset/OneMillion/1M-WorstCase.csv";
        String Avg1M = "src/dataset/OneMillion/1M-AverageCase.csv";

        // Create an ArrayList to store the file paths
        ArrayList<String> filePathsInList = new ArrayList<>();

        // Add all the file paths to the ArrayList
        filePathsInList.add(Best10K);
        filePathsInList.add(Worst10K);
        filePathsInList.add(Avg10K);

        filePathsInList.add(Best50K);
        filePathsInList.add(Worst50K);
        filePathsInList.add(Avg50K);

        filePathsInList.add(Best200K);
        filePathsInList.add(Worst200K);
        filePathsInList.add(Avg200K);

        filePathsInList.add(Best500K);
        filePathsInList.add(Worst500K);
        filePathsInList.add(Avg500K);

        filePathsInList.add(Best1M);
        filePathsInList.add(Worst1M);
        filePathsInList.add(Avg1M);

        // Return the ArrayList containing the file paths
        return filePathsInList;
    } // end of createFilePathInLIst method

    /**
     * Sorts the given array using the Selection Sort algorithm.
     * @param fileName Array of Strings to be sorted.
     * @return int count of statements executed in the method.
     */
    public static long selectionSort(String fileName) {
       /*
            ALGORITHM:
            1. Read data from the CSV file into an array.
            2. Initialize statementCount to 0.
            3. Iterate through the array using Selection Sort algorithm
            4. Return the statementCount variable.
        */

        // Read the data from the CSV file into an array
        String[] array = CSVReader.readDataFromFile(fileName);

        // Initialize statement count to track executed statements
        long statementCount = 0;

        // Iterate through the array to sort it using Selection Sort algorithm
        for(int i=0; i < array.length-1; i++){
            statementCount += 4;  // Add 4 to statement count for initialization and loop control statements
            int minIndex = i; // Track the index of the smallest element in the unsorted part
            statementCount++;

            // Iterate through the unsorted part of the array to find the minimum element
            for (int j=i+1; j < array.length; j++){
                // Add 4 to statement count for initialization and loop control statements
                statementCount += 4;
                // Update minIndex if a smaller element is found
                if (array[j].compareToIgnoreCase(array[minIndex]) < 0) {
                    statementCount ++;
                    minIndex = j;
                    statementCount++;
                } // end of inner for loop
            } // end of if condition

            // Swap the found minimum element with the first element in the unsorted part
            String temp = array[minIndex];
            statementCount++;
            array [minIndex] = array[i];
            statementCount ++;
            array[i] = temp;
            statementCount++;
        } // end of outer for loop

        return statementCount;
    } // end of selectionSort method

    /**
     * Displays execution times for insertion sort in different cases and input sizes.
     * @param results a 2D array of execution times for insertion sort. The rows represent
     *      input sizes, while columns represent best, worst, and average cases.
     */
    public static void displayCounts(long[][] results){
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
            } // end of inner loop
        } // end of outer loop
    } // end of displayCounts method

} // end of SelectionSort class

