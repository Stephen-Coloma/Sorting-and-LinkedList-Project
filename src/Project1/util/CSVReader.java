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

package Project1.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    /**
     * Reads data from a CSV file and returns it as an array of strings.
     * @param fileName The path to the CSV file to be read.
     * @return An array of strings containing the data read from the CSV file.
     */
    /*
     * Algorithm:
     * 1. Create an empty ArrayList to store the data.
     * 2. Open the CSV file for reading using BufferedReader and FileReader.
     * 3. Read each line from the file using a loop.
     * 4. Add each line to the ArrayList.
     * 5. Close the file after reading.
     * 6. Convert the ArrayList to an array and return it.
     */
    public static String[] readDataFromFile(String fileName) {
        List<String> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            } // end of try
        } catch (IOException e) {
            e.printStackTrace();
        } // end of catch
        return dataList.toArray(new String[0]);
    }
}
