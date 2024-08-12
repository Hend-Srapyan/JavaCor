package classwork;

public class BoxDemo6 {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();
        double vol;
        vol = myBox1.vol();
        System.out.println("Oбъeм равен " + vol);

        vol = myBox2.vol();
        System.out.println("Oбъeм равен " + vol);
    }
}
