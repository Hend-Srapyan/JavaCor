package classwork;

public class Box {
    double width;
    double height;
    double depth;

    Box(){
        System.out.println("Koнcтpyиpoвaниe объекта Вох");
        width = 10;
        height = 10;
        depth = 10;
    }

    Box(double w, double h, double d){
        width = w;
        height = h;
        depth = d;

    }

    void volume(){
        System.out.print("Oбъeм равен ");
        System.out.println(width * height * depth);
    }

    double vol(){
       return width * height * depth;
    }

    void setDim(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
}
