package homework;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray dy = new DynamicArray();
        for (int i = 1; i < 777; i++) {
            dy.add(i);
        }
        dy.print();
    }
}
