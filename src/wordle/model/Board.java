package wordle.model;

/**
 * Manages the current state of a Wordle game.
 *
 * <p>Stores information about the guesses made and the state of the game.</p>
 */
public class Board {
    private static final int MAX_GUESSES = 6;

    private final Guess[] guesses = new Guess[MAX_GUESSES];
    private int numGuesses = 0;
    private GameResult gameResult = GameResult.ACTIVE;

    /**
     * Returns a specific guess that has already been made.
     *
     * @param index the index of the guess
     * @return the guess made at the given index
     * @throws IndexOutOfBoundsException if the index is outside the board
     *     bounds
     * @throws IllegalStateException if no guess exists at the specified index
     */
    public Guess getGuess(int index) {
        // Ensure that the index refers to a valid position on the board.
        if (index < 0 || index >= MAX_GUESSES) {
            throw new IndexOutOfBoundsException(
                "Guess index must be between 0 and " + (MAX_GUESSES - 1)
            );
        }

        // Ensure that a guess exists at the specified index.
        if (index >= numGuesses) {
            throw new IllegalStateException(
                "No guess exists at index " + index
            );
        }

        return guesses[index];
    }

    /**
     * Returns the latest guess on the board.
     *
     * @return the latest guess
     * @throws IllegalStateException if the board does not contain any guesses
     */
    public Guess getLatestGuess() {
        // Ensure that the board contains at least one guess.
        if (numGuesses == 0) {
            throw new IllegalStateException(
                "The board has no guesses"
            );
        }

        return guesses[numGuesses - 1];
    }

    /**
     * Adds a guess to the board.
     *
     * @param guess the most recent guess
     * @throws IllegalStateException if the game is over or no guesses remain
     * @throws IllegalArgumentException if the guess is {@code null}
     */
    public void addGuess(Guess guess) {
        // Ensure that the game is not already over.
        if (gameResult == GameResult.WON || gameResult == GameResult.LOST) {
            throw new IllegalStateException(
                "Cannot make a guess because the game is over: " + gameResult
            );
        }

        // Ensure that the guess is valid.
        if (guess == null) {
            throw new IllegalArgumentException(
                "Guess cannot be null"
            );
        }

        // Ensure that guesses remain.
        if (numGuesses >= MAX_GUESSES) {
            throw new IllegalStateException(
                "The board already contains " + MAX_GUESSES + " guesses"
            );
        }

        guesses[numGuesses] = guess;
        numGuesses++;

        // Update the game state based on the submitted guess.
        if (guess.isCorrect()) {
            gameResult = GameResult.WON;
        } else if (numGuesses == MAX_GUESSES) {
            gameResult = GameResult.LOST;
        }
    }

    /**
     * Returns the result of the game.
     *
     * @return the game's result
     */
    public GameResult getGameResult() {
        return gameResult;
    }
}
