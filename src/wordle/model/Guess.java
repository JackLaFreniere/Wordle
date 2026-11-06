package wordle.model;

import java.util.Arrays;

/**
 * Represents a valid Wordle guess.
 *
 * <p>Stores the guessed word and the result for each letter.</p>
 */
public final class Guess {
    private static final int WORD_LENGTH = 5;

    private final String word;
    private final LetterResult[] results;

    /**
     * Validates and stores a Wordle guess.
     *
     * @param word the guessed word
     * @param results the result for each letter
     * @throws IllegalArgumentException if the word does not contain five
     *     letters or the results do not contain one valid result per letter
     */
    public Guess(String word, LetterResult[] results) {
        // Ensure that the word exists and has the correct length.
        if (word == null || word.length() != WORD_LENGTH) {
            throw new IllegalArgumentException(
                "A guess must contain " + WORD_LENGTH + " letters"
            );
        }

        // Ensure that results exist and contain one element per letter.
        if (results == null || results.length != WORD_LENGTH) {
            throw new IllegalArgumentException(
                "A guess must contain " + WORD_LENGTH + " letter results"
            );
        }

        // Ensure that every result is non-null.
        for (LetterResult letter : results) {
            if (letter == null) {
                throw new IllegalArgumentException (
                    "Every letter result in results cannot be null"
                );
            }
        }

        this.word = word;
        this.results = Arrays.copyOf(results, results.length);
    }

    /**
     * Returns the guessed word.
     *
     * @return the guessed word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the letter at the specified index.
     *
     * @param index the index of the letter in the word
     * @return the letter in the word
     */
    public char getLetter(int index) {
        validateIndex(index);

        return word.charAt(index);
    }

    /**
     * Returns the results for each letter.
     *
     * @return an array of letter results
     */
    public LetterResult[] getResults() {
        return Arrays.copyOf(results, results.length);
    }

    /**
     * Returns the result at the specified index.
     *
     * @param index the index of the letter in the word
     * @return the result of the letter at the specified index
     */
    public LetterResult getResult(int index) {
        validateIndex(index);

        return results[index];
    }

    /**
     * Determines whether this guess is correct.
     *
     * @return {@code true} if every letter in the word is correct;
     *     {@code false} otherwise
     */
    public boolean isCorrect() {
        for (LetterResult result : results) {
            if (result != LetterResult.CORRECT) {
                return false;
            }
        }

        return true;
    }

    /**
     * Validates that the index refers to a letter in the word.
     *
     * @param index the index to validate
     */
    private void validateIndex(int index) {
        // Ensure that the index refers to a valid letter in the guess.
        if (index < 0 || index >= WORD_LENGTH) {
            throw new IllegalArgumentException(
                "Letter index must be between 0 and " + (WORD_LENGTH - 1)
            );
        }
    }
}
