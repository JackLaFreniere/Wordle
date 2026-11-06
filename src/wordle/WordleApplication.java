package wordle;

import wordle.model.Board;
import wordle.solver.Solver;

public class WordleApplication {
    private final Solver solver;

    public WordleApplication(Solver solver) {
        this.solver = solver;
    }

    public void run() {
        System.out.println("Hello World!");
    }
}
