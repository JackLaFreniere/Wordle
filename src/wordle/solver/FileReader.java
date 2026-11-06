package wordle.solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Loads Wordle words from the project's resource files.
 *
 * <p>This utility class provides access to the list of allowed guesses and
 * the list of possible answers. It cannot be instantiated because all of its
 * operations are static.</p>
 */
public final class FileReader {
    // File names and directory to those files
    private static final String GUESS_LIST_FILE_NAME = "allowed_guesses.txt";
    private static final String ANSWER_LIST_FILE_NAME = "possible_answers.txt";
    private static final String RESOURCE_DIRECTORY = "src/resources/";

    /**
     * Prevents instances of this utility class from being created.
     */
    private FileReader() {}

    /**
     * Loads all words that Wordle allows the player to submit.
     *
     * @return a list containing the allowed guesses
     * @throws IllegalStateException if the word-list file cannot be found
     */
    public static List<String> getGuesses() {
        return readWords(GUESS_LIST_FILE_NAME);
    }

    /**
     * Loads all words that can be used as Wordle answers.
     *
     * @return a list containing the possible answers
     * @throws IllegalStateException if the word-list file cannot be found
     */
    public static List<String> getAnswers() {
        return readWords(ANSWER_LIST_FILE_NAME);
    }

    /**
     * Reads each non-empty line from a word-list file.
     *
     * @param fileName the name of the word-list file
     * @return the words read from the file
     * @throws IllegalStateException if the word-list file cannot be found
     */
    private static List<String> readWords(String fileName) {
        List<String> words = new ArrayList<>();
        File file = new File(RESOURCE_DIRECTORY + fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();

                // Ignore blank lines so they are not treated as words.
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
