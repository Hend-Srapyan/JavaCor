package homework;


public class FigurePainter {

    void figureOne(int n, char c) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void figureTwo(int n, char c) {
        for (int i = n; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(c + " ");
            }
            System.out.println();

        }
    }

    void figureThree(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print(c + " ");
            }

            System.out.println();
        }
        System.out.println();
    }


    void figureFour(int n, char c) {
        for (int i = n; i > 0; i--) {
            for (int j = n - i; j > 0; j--) {
                System.out.print("  ");
            }
            for (int j = i - 1; j > 0; j--) {
                System.out.print(c + " ");
            }

            System.out.println();
        }
    }

    void figureFive(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print(c + " ");
            }

            System.out.println();
        }
        for (int i = n; i > 0; i--) {
            for (int j = n - i; j > 0; j--) {

                System.out.print(" ");
            }
            System.out.print(" ");
            for (int j = i - 1; j > 0; j--) {
                ;
                System.out.print(c + " ");
            }

            System.out.println();
        }
    }
}



