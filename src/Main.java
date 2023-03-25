/**
 * @author Trevor Hartman
 * @author Mike Quist
 * @date 03/25/23
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file path to gather stats on, or Q to quit:");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                break;
            } else {
                if (!new File(input).exists()) {
                    System.out.println("Invalid file path, please try again or enter Q to quit:");
                    continue;
                }

                // Write a loop that will ask the user to enter a file path to gather stats on,
                // and continue until "Q" is entered.

                // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File
                Path path = Paths.get(input);
                File f = path.toFile();
                boolean skipWs = false;


                // Ask the user if they would like to skip whitespace
                System.out.println("Would you like to skip whitespace? y or n");
                String input2 = scanner.nextLine();
                if (input2.equalsIgnoreCase("y")) {
                    skipWs = true;
                } else if (input2.equalsIgnoreCase("n")) {
                    skipWs = false;
                } else System.out.println("Please enter 'y' or 'n'!");


                // Create a variable called skipWs that stores the user's response as a boolean

                /*
                 * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
                 * write code to get the line, word, and character count of the File object created above!
                 */
                try {
                    // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                    FileStats fs = new FileStats(f, skipWs);
                    fs.read();
                    String stats = String.format("Stats: lines - %d, words - %d, chars - %d %s", fs.getNumLines(), fs.getNumWords(), fs.getNumChars(), f.getAbsolutePath());
                    System.out.println(stats);
                    // You will need to call the fs.read method, which you need to implement!

                    /*
                     * You will access the FileStats object's getter methods to get the file's line, word, character count and
                     * the files name. You should use a format specifier to print it all out similar to the following example:
                     *
                     * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                     */
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }

            }
        }
    }
}
