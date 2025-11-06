package tasks.intermediate;

import java.io.*;

public class FileHandlingTask {
    public static void main(String[] args) {
        String inputFile = "src/tasks/intermediate/input.txt";
        String outputFile = "src/tasks/intermediate/output.txt";

        try {
            // Read from Input File

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            int lineCount = 0;
            int wordCount = 0;

            while ((line = reader.readLine()) != null){
                lineCount++;
                if (!line.trim().isEmpty()){
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                }
            }
            reader.close();

            // Write processed data from output file

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write("===== File Processing Summary =====\n");
            writer.write("Total Lines: "+ lineCount + "\n");
            writer.write("Total Words: "+ wordCount + "\n");
            writer.close();

            System.out.println("===== File Processing Summary =====");
            System.out.println("      Total Lines: "+ lineCount);
            System.out.println("      Total Words: "+ wordCount + "\n");
            System.out.println("File processed successfully!");
            System.out.println("Lines: " + lineCount + " | Words: " + wordCount);
            System.out.println("Output saved to: " + outputFile);

        } catch (FileNotFoundException e){
            System.out.println("Error: Input file not found!");
        } catch (IOException e){
            System.out.println("Error while reading or writing file!");
        }
    }
}
