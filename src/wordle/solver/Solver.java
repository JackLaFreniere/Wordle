package wordle.solver;

import wordle.model.Board;

public interface Solver {
    public String nextGuess(Board board);
}
