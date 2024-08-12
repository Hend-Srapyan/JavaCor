package classwork;

public class BoxDemo7 {
    public static void main(String[] args) {
        Box myBox1 = new Box(10, 20, 15);
        Box myBox2 = new Box(3, 6, 9);

        double vol;

        vol = myBox1.vol();
        System.out.println("Oбъeм равен " + vol);

        vol = myBox2.vol();
        System.out.println("Oбъeм равен " + vol);

    }
}
