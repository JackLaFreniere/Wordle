package wordle;

public class Main {
    public static void main(String[] args) {
        try {
            new WordleApplication().run();
        } catch (Exception e) {
            System.err.println("Wordle solver failed: " + e.getMessage());
            System.exit(1);
        }
    }
}