package homework.bracechecker;

public class Stack {
    private int[] array = new int[10];
    private int tos;


    public Stack() {
        tos = -1;
    }

    public void push(int item) {
        if (tos == 9) {
            System.out.println("Cтeк заполнен.");
        } else {
            array[++tos] = item;
        }
    }

    public int pop() {
        if (tos < 0) {
            System.out.println("Cтeк не загружен.");
            return 0;
        } else {
            return array[tos--];
        }
    }
}
