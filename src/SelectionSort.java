import java.util.ArrayList;

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
 */


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

        int sizeVariants = 5;
        int arrangementVariants = 3;

        long[][] results = new long[sizeVariants][arrangementVariants];

        ArrayList<String> filePathInList= createFilePathInList();

        int fileNumber = 0;

        for (int i = 0; i < sizeVariants; i++) {
            for (int j = 0; j < arrangementVariants; j++) {
                results[i][j] = insertionSort(filePathInList.get(fileNumber));
                fileNumber++;
                System.out.println("File: " + fileNumber);
            }
        }

        displayCounts(results);

    }

    /**
     * Sorts the given array using the Selection Sort algorithm.
     * @param arr Array of Strings to be sorted.
     * @return int count of statements executed in the method.
     */
    public static int selectionSort(String arr) {
        /*ALGORITHM:
          1. Implement the Selection Sort algorithm
          2. Initialize statementCount to 0;
          2. For every statement in the algorithm, increment the statementCount
          4. return statementCount variable
          */
        return 1;
    } // end of selectionSort method

    public static void displayCounts(){

    }
} // end of SelectionSort class

