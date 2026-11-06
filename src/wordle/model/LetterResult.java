package wordle.model;

/**
 * Represents the possible states of a letter in Wordle.
 */
public enum LetterResult {
    CORRECT, // Green: the letter is in the correct position.
    PRESENT, // Yellow: the letter is in the word but in the wrong position.
    ABSENT // Black: the letter is not in the word.
}
