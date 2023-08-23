import util.CSVReader;

import javax.management.StringValueExp;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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





    }//end of main

    private static ArrayList<String> createFilePathInList() {
        String Best10K = "src/dataset/TenThousand/10K-BestCase.csv";
        String Worst10K = "src/dataset/TenThousand/10K-WorstCase.csv";
        String Avg10K = "src/dataset/TenThousand/10K-AverageCase.csv";

        String Best50K = "src/dataset/FiftyThousand/50K-BestCase.csv";
        String Worst50K = "src/dataset/FiftyThousand/50K-WorstCase.csv";
        String Avg50K = "src/dataset/FiftyThousand/50K-AverageCase.csv";

        String Best200K = "src/dataset/TwoHundredThousand/200K-BestCase.csv";
        String Worst200K = "src/dataset/TwoHundredThousand/200K-WorstCase.csv";
        String Avg200K = "src/dataset/TwoHundredThousand/200K-AverageCase.csv";

        String Best500K = "src/dataset/FiveHundredThousand/500K-BestCase.csv";
        String Worst500K = "src/dataset/FiveHundredThousand/500K-WorstCase.csv";
        String Avg500K = "src/dataset/FiveHundredThousand/500K-AverageCase.csv";

        String Best1M = "src/dataset/OneMillion/1M-BestCase.csv";
        String Worst1M = "src/dataset/OneMillion/1M-WorstCase.csv";
        String Avg1M = "src/dataset/OneMillion/1M-AverageCase.csv";


        ArrayList<String> filePathsInList = new ArrayList<String>();

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

        return filePathsInList;
    }

    /**
     * Sorts the given array using the Insertion Sort algorithm.
     * @param filename name of file to be read.
     * @return int count of statements executed in the method.
     */
    public static long selectionSort(String filename) {
        /*ALGORITHM:
          1. Implement the Insertion Sort algorithm
          2. Initialize statementCount to 0;
          2. For every statement in the algorithm, increment the statementCount
          4. return statementCount variable
          */
        String[] arr = CSVReader.readDataFromFile(filename);
        long statementCount=0;
        for (int i = 1; i < arr.length; i++) {
            statementCount+=3;
            String key = arr[i];
            statementCount++;
            int j = i - 1;
            statementCount+=2;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                statementCount += 3;
                arr[j + 1] = arr[j];
                statementCount+=2;
                j--;
                statementCount++;
            }
            arr[j + 1] = key;
            statementCount+=2;
        }
        return statementCount;
    }// end of sort method
    public static void displayCounts(long[][] insertionSortCount) {


    }
} // end of InsertionSort class

