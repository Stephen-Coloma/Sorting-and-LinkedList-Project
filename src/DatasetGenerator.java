import java.io.*;
import java.util.*;

public class DatasetGenerator {
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
        writeData(stringArray,fileNameAverage);

        //Sort ascending
        sortAscending(stringArray);
        writeData(stringArray,fileNameBest);

        sortDescending(stringArray);
        writeData(stringArray, fileNameWorst);
    }


    /*Todo
    *  1. Generate a method that generates n number of unique strings
    *  2. Generate a method that sorts the array in ascending order
    *  3. Generate a method that sorts the array in descending order
    *  4. Generate a method that writes all the elements in csv file*/
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
    }

    private static void sortAscending(String[] array){
        Arrays.sort(array);
    }

    private static void sortDescending(String[] array){
        Arrays.sort(array);
        // Converting the array to a list
        List<String> arrayAsList = Arrays.asList(array);

        // Reversing the list
        Collections.reverse(arrayAsList);
    }

    private static void writeData(String[] array, String fileName){
        try (FileWriter writer = new FileWriter(new File(fileName))){

            System.out.print("Writing raw... ");
            write(array, writer);
        } catch (FileNotFoundException fnfe){
            System.out.println("Not found");
        }catch (IOException ioe){
            System.out.println("Error Occured");
        }
    }

    private static void write(String[] records, Writer writer) throws IOException {
        long start = System.currentTimeMillis();
        for (String record: records) {
            writer.write(record+"\n");
        }
        // writer.flush(); // close() should take care of this
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f + " seconds");
    }
}
