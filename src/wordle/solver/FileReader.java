package wordle.solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class FileReader {
    private static final String GUESS_LIST_FILE_NAME = "allowed_guesses.txt";
    private static final String ANSWER_LIST_FILE_NAME = "possible_answers.txt";
    private static final String RESOURCE_DIRECTORY = "src/resources/";

    private FileReader() {}

    public static List<String> getGuesses() {
        return readWords(GUESS_LIST_FILE_NAME);
    }

    public static List<String> getAnswers() {
        return readWords(ANSWER_LIST_FILE_NAME);
    }

    private static List<String> readWords(String fileName) {
        List<String> words = new ArrayList<>();
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
