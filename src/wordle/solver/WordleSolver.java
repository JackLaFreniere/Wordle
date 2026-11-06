package wordle.solver;

import java.util.List;

import wordle.model.Board;

public class WordleSolver implements Solver{
    private List<String> possibleAnswers;
    private List<String> allowedGuesses;

    @Override
    public String nextGuess(Board board) {
        getInitialWords();

        return "";
    }

    private void getInitialWords() {
        possibleAnswers = FileReader.getAnswers();
        allowedGuesses = FileReader.getGuesses();
    }
}
