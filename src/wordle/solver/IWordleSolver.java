package wordle.solver;

import wordle.model.Board;

public interface IWordleSolver {
    String nextGuess(Board board);
}