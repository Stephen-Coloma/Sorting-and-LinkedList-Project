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

import java.io.*;
import java.util.*;

/**
 * The DatasetGenerator class generates, sorts, and writes datasets of unique strings.
 * It demonstrates the generation of unique strings, sorting them in ascending and descending order,
 * and writing the datasets to CSV files for various arrangement variants (Best, Worst, Average).
 */
public class DatasetGenerator {
    /**
     * Main method generates, sorts, and writes datasets of unique strings.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Set<String> uniqueStrings = new HashSet<>();
        Random random = new Random();

        while (uniqueStrings.size() < 1_000_000) {
            String generatedString = generateRandomString(random);
            uniqueStrings.add(generatedString);
        }

        String fileNameAverage = "src/dataset/OneMillion/1M-AverageCase.csv";
        String fileNameBest = "src/dataset/OneMillion/1M-BestCase.csv";
        String fileNameWorst = "src/dataset/OneMillion/1M-WorstCase.csv";

        //Convert Set to String[] array
        String[] stringArray = uniqueStrings.toArray(new String[0]);

        //writing average case data
//        writeData(stringArray,fileNameAverage);

        //Sort ascending
        sortAscending(stringArray);
//        writeData(stringArray,fileNameBest);

        sortDescending(stringArray);
//        writeData(stringArray, fileNameWorst);
    }

    /**
     * Generates a random list of strings.
     * @param random a variable that randomizes strings.
     * @return String list of randomized strings.
     */
    private static String generateRandomString(Random random) {
        int length = 5; // Adjust the length as needed
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }// end of generateRandomString method

    /**
     * Sorts the array in ascending order.
     * @param array list of strings to be sorted.
     */
    private static void sortAscending(String[] array){
        Arrays.sort(array);
    }// end of sortAscending method

    /**
     * Sorts the array in descending order.
     * @param array list of strings to be sorted.
     */
    private static void sortDescending(String[] array){
        Arrays.sort(array);
        // Converting the array to a list
        List<String> arrayAsList = Arrays.asList(array);

        // Reversing the list
        Collections.reverse(arrayAsList);
    }// end of sortDescending method

    /**
     * Writes array of data in a file.
     * @param array list of strings to be written into a file.
     * @param fileName file directory of the data.
     */
    private static void writeData(String[] array, String fileName){
        try (FileWriter writer = new FileWriter(new File(fileName))){

            System.out.print("Writing raw... ");
            write(array, writer);
        } catch (FileNotFoundException fnfe){
            System.out.println("Not found");
        }catch (IOException ioe){
            System.out.println("Error Occured");
        }
    }// end of writeData method

    /** 
    * Supporting method for the writeData method in writing data in a file.
    * @param records - the array of unique Strings to be written in a file
    * @param writer - writer object that handles the writing process.
    */
    private static void write(String[] records, Writer writer) throws IOException {
        long start = System.currentTimeMillis();
        for (String record: records) {
            writer.write(record+"\n");
        }
        // writer.flush(); // close() should take care of this
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f + " seconds");
    }// end of write method

}// end of DatasetGenerator class