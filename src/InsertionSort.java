import util.CSVReader;

import javax.management.StringValueExp;
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
    static String Best10K = "src/dataset/TenThousand/10K-BestCase.csv";
    static String Avg10K = "src/dataset/TenThousand/10K-AverageCase.csv";
    static String Worst10K = "src/dataset/TenThousand/10K-WorstCase.csv";
    static String Best50K = "src/dataset/FiftyThousand/50K-BestCase.csv";
    static String Avg50K = "src/dataset/FiftyThousand/50K-AverageCase.csv";
    static String Worst50K = "src/dataset/FiftyThousand/50K-WorstCase.csv";
    static String Best200K = "src/dataset/TwoHundredThousand/200K-BestCase.csv";
    static String Avg200K = "src/dataset/TwoHundredThousand/200K-AverageCase.csv";
    static String Worst200K = "src/dataset/TwoHundredThousand/200K-WorstCase.csv";
    static String Best500K = "src/dataset/FiveHundredThousand/500K-BestCase.csv";
    static String Avg500K = "src/dataset/FiveHundredThousand/500K-AverageCase.csv";
    static String Worst500K = "src/dataset/FiveHundredThousand/500K-WorstCase.csv";
    static String Best1M = "src/dataset/OneMillion/1M-BestCase.csv";
    static String Avg1M = "src/dataset/OneMillion/1M-AverageCase.csv";
    static String Worst1M = "src/dataset/OneMillion/1M-WorstCase.csv";
    public static void main(String[] args) {

        Scanner kbd = new Scanner(System.in);
        char repeat;
        do {
            int unitChoice = getUnitsChoice(kbd);
            int caseAnswer = getCaseChoice(kbd);
            long insertionSortCount;
            switch (unitChoice) {
                case 1 -> {
                    if (caseAnswer == 1) {
                        insertionSortCount = sort(Best10K);
                        displayCounts(insertionSortCount);
                    } else if (caseAnswer == 2) {
                        insertionSortCount = sort(Avg10K);
                        displayCounts(insertionSortCount);
                    } else {
                        insertionSortCount = sort(Worst10K);
                        displayCounts(insertionSortCount);
                    }
                }
                case 2 -> {
                    if (caseAnswer == 1) {
                        insertionSortCount = sort(Best50K);
                        displayCounts(insertionSortCount);
                    } else if (caseAnswer == 2) {
                        insertionSortCount = sort(Avg50K);
                        displayCounts(insertionSortCount);
                    } else {
                        insertionSortCount = sort(Worst50K);
                        displayCounts(insertionSortCount);
                    }
                }
                case 3 -> {
                    if (caseAnswer == 1) {
                        insertionSortCount = sort(Best200K);
                        displayCounts(insertionSortCount);
                    } else if (caseAnswer == 2) {
                        insertionSortCount = sort(Avg200K);
                        displayCounts(insertionSortCount);
                    } else {
                        insertionSortCount = sort(Worst200K);
                        displayCounts(insertionSortCount);
                    }
                }
                case 4 -> {
                    if (caseAnswer == 1) {
                        insertionSortCount = sort(Best500K);
                        displayCounts(insertionSortCount);
                    } else if (caseAnswer == 2) {
                        insertionSortCount = sort(Avg500K);
                        displayCounts(insertionSortCount);
                    } else {
                        insertionSortCount = sort(Worst500K);
                        displayCounts(insertionSortCount);
                    }
                }
                case 5 -> {
                    if (caseAnswer == 1) {
                        insertionSortCount = sort(Best1M);
                        displayCounts(insertionSortCount);
                    } else if (caseAnswer == 2) {
                        insertionSortCount = sort(Avg1M);
                        displayCounts(insertionSortCount);
                    } else {
                        insertionSortCount = sort(Worst1M);
                        displayCounts(insertionSortCount);
                    }
                }
            }
            System.out.print("Try Again? (Y/N): ");
            repeat = kbd.nextLine().charAt(0);
            repeat = Character.toUpperCase(repeat);

        } while (repeat == 'Y');
    }//end of main

    /**
     * Sorts the given array using the Insertion Sort algorithm.
     * @param filename name of file to be read.
     * @return int count of statements executed in the method.
     */
    public static long sort(String filename) {
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
    public static void displayCounts(long insertionSortCount){
        System.out.println("Statement Counts:");
        int length = String.valueOf(insertionSortCount).length();
        String unit="";
        if(length>= 16)
            unit="Quadrillion";
            else if(length >=13)
                unit="Trillion";
                else if(length>=10)
                    unit="Billion";
                    else if(length>=7)
                        unit="Million";
                        else if(length<4)
                            unit="Thousand";
        System.out.println("Insertion Sort: " + insertionSortCount +" "+ unit+" statements" );

    }
    public static int getUnitsChoice(Scanner kbd) {
        System.out.println("Which one do you want to sort?");
        System.out.println("1. Ten Thousand");
        System.out.println("2. Fifty Thousand");
        System.out.println("3. Two Hundred Thousand");
        System.out.println("4. Five Hundred Thousand");
        System.out.println("5. One Million");
        return (Integer.parseInt(kbd.nextLine()));
    }
    public static int getCaseChoice(Scanner kbd){
        System.out.println(" Which Case? ");
        System.out.println("1. Best Case");
        System.out.println("2. Average Case");
        System.out.println("3. Worst Case");
        return(Integer.parseInt(kbd.nextLine()));
    }
} // end of InsertionSort class

