package homework;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray dy = new DynamicArray();
        dy.add(5);
        dy.add(6);
        dy.add(7);
        dy.add(8);
        dy.add(10);
        dy.print();
        dy.add(1,9);
        dy.print();
        System.out.println(dy.getIndexByValue(7));
    }
}
