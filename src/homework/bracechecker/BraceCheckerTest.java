package homework.bracechecker;

public class BraceCheckerTest {
    public static void main(String[] args) {
        String text = "Hello (from) [Java}";
        BraceChecker bc = new BraceChecker(text);
        bc.check();

    }

}
