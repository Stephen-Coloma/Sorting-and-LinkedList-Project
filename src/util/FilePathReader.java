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
package util;

import java.util.ArrayList; // Importing ArrayList class for creating dynamic lists

/**
 * The FilePathReader class is a utility class that provides methods to create and manage file paths for different dataset cases.
 * It allows the creation of an ArrayList containing file paths for various dataset sizes and arrangement variants.
 */
public class FilePathReader {
    /**
     * Creates a list of file paths for the datasets.
     * Adds these files to the ArrayList.
     * @return the ArrayList of file paths corresponding to different dataset cases
     */
    /*
        ALGORITHM:
        1. Define file paths for various dataset cases (10K, 50K, 200K, 500K, 1M) 
           and arrangement variants (Best, Worst, Average).
        2. Create an ArrayList to store the file paths.
        3. Add all the defined file paths to the ArrayList.
        4. Return the ArrayList containing the file paths for different dataset cases.
    */    
    public static ArrayList<String> createFilePathInList() {
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
    } //  end of createFilePathInLIst method
}//end of FilePathReader class