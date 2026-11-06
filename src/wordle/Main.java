package wordle;

import wordle.solver.Solver;
import wordle.solver.WordleSolver;

public class Main {
    public static void main(String[] args) {
        try {
            Solver solver = new WordleSolver();

            new WordleApplication(solver).run();
        } catch (Exception e) {
            System.err.println("Wordle solver failed: " + e.getMessage());
            System.exit(1);
        }
    }
}