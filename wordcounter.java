//wordcounter
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = "";

        System.out.println("Word Counter");
        System.out.println("1. Enter 'T' to input text manually.");
        System.out.println("2. Enter 'F' to provide a file path for counting words.");
        System.out.print("Your choice: ");

        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("t")) {
            System.out.print("Enter the text: ");
            inputText = scanner.nextLine();
        } else if (choice.equals("f")) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    inputText += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Exiting the program.");
                System.exit(0);
            }
        } else {
            System.out.println("Invalid input. Exiting the program.");
            System.exit(0);
        }

        int wordCount = countWords(inputText);
        System.out.println("Total words: " + wordCount);
    }

    private static int countWords(String inputText) {
        String[] words = inputText.split("\\s+|\\p{Punct}"); // Split by space or punctuation
        return words.length;
    }
}
