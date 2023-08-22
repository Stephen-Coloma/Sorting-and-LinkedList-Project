package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Utility class to handle CSV operations
public class CSVReader {
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
    } // end of readDataFromFile method
} // end of CSVUtil
