package homework;

public class Sort {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 3, 9, 0, 2};

        for (int x : array) {
            System.out.print(x + " ");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] > array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;

                }

            }
        }

        System.out.println();
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}
