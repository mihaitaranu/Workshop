package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Taranu on 25/04/15.
 */
public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
