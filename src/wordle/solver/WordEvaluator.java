package wordle.solver;

import wordle.model.Guess;
import wordle.model.LetterResult;

/**
 * Evaluates Wordle guesses against possible answers.
 *
 * <p>This class calculates the result for each letter and checks whether a
 * candidate answer is consistent with previously calculated feedback.</p>
 */
public class WordEvaluator {
    /**
     * Determines whether a candidate answer matches a previous guess.
     *
     * @param previousGuess the guess and feedback to compare against
     * @param candidate the possible answer to check
     * @return {@code true} if the candidate produces the same feedback;
     *     {@code false} otherwise
     * @throws IllegalArgumentException if the previous guess or candidate is
     *     {@code null}
     */
    public boolean matches(Guess previousGuess, String candidate) {
        // Ensure that the guess and candidate are not null.
        if (previousGuess == null || candidate == null) {
            throw new IllegalArgumentException(
                "The previous guess and candidate cannot be null"
            );
        }

        LetterResult[] candidateResults = evaluate(
            previousGuess.getWord(),
            candidate
        );
        LetterResult[] guessResults = previousGuess.getResults();

        // Compare the calculated feedback with the feedback from the guess.
        for (int i = 0; i < candidateResults.length; i++) {
            if (candidateResults[i] != guessResults[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Calculates the Wordle result for each letter in a guess.
     *
     * <p>Exact matches are found first. The remaining letters are then
     * checked for matches in unused answer positions so repeated letters are
     * handled correctly.</p>
     *
     * @param guess the word being evaluated
     * @param answer the candidate answer
     * @return the result for each letter in the guess
     * @throws IllegalArgumentException if either word is {@code null} or the
     *     words have different lengths
     */
    public LetterResult[] evaluate(String guess, String answer) {
        // Ensure that the guess and answer are not null.
        if (guess == null || answer == null) {
            throw new IllegalArgumentException(
                "The guess and answer cannot be null"
            );
        }

        // Ensure that the guess and answer have the same length.
        if (guess.length() != answer.length()) {
            throw new IllegalArgumentException(
                "The guess and answer must have the same length"
            );
        }

        LetterResult[] results = new LetterResult[guess.length()];
        boolean[] usedLetters = new boolean[answer.length()];

        // Mark letters that are correct and in the correct position.
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == answer.charAt(i)) {
                results[i] = LetterResult.CORRECT;
                usedLetters[i] = true;
            }
        }

        // Mark remaining letters as present or absent.
        for (int i = 0; i < guess.length(); i++) {
            if (results[i] == LetterResult.CORRECT) {
                continue;
            }

            results[i] = LetterResult.ABSENT;

            for (int j = 0; j < answer.length(); j++) {
                if (!usedLetters[j]
                        && guess.charAt(i) == answer.charAt(j)) {

                    // Consume each matching answer letter only once.
                    results[i] = LetterResult.PRESENT;
                    usedLetters[j] = true;
                    break;
                }
            }
        }

        return results;
    }
}
