package homework.bracechecker;

public class BraceChecker {
    private String text;


    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        Stack myStack = new Stack();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char last;
            int pop;
            switch (c) {
                case '{':
                case '[':
                case '(':
                    myStack.push(c);
                    break;
                case '}':
                    pop = myStack.pop();
                    if (pop == 0) {
                        System.out.println("Error: Closed " + c + " but not opened at " + i);
                    } else {
                        last = (char) pop;

                        if (last != '{') {
                            System.out.println("Error: Closed " + c + " but opened " + last + " at " + i);
                        }
                    }
                    break;
                case ']':
                    pop = myStack.pop();
                    if (pop == 0) {
                        System.out.println("Error: Closed " + c + " but not opened at " + i);
                    } else {
                        last = (char) pop;

                        if (last != '[') {
                            System.out.println("Error: Closed " + c + " but opened " + last + " at " + i);
                        }
                    }
                    break;
                case ')':
                    pop = myStack.pop();
                    if (pop == 0) {
                        System.out.println("Error: Closed " + c + " but not opened at " + i);
                    } else {
                        last = (char) pop;

                        if (last != '(') {
                            System.out.println("Error: Closed " + c + " but opened " + last + " at " + i);
                        }
                    }
                    break;

            }
        }

    }
}
