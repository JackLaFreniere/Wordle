package wordle.solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private static final String GUESS_LIST_FILE_NAME = "allowed_guesses.txt";
    private static final String ANSWER_LIST_FILE_NAME = "possible_answers.txt";
    private static final String RESOURCE_DIRECTORY = "src/resources/";

    public static ArrayList<String> getGuesses() {
        return readWords(GUESS_LIST_FILE_NAME);
    }

    public static ArrayList<String> getAnswers() {
        return readWords(ANSWER_LIST_FILE_NAME);
    }

    private static ArrayList<String> readWords(String fileName) {
        ArrayList<String> words = new ArrayList<String>();
        File file = new File(RESOURCE_DIRECTORY + fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();

                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException exception) {
            throw new IllegalStateException("Could not find file: " + file, exception);
        }

        return words;
    }
}
