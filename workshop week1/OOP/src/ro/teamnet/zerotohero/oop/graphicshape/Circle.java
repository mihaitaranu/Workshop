package ro.teamnet.zerotohero.oop.graphicshape;


/**
 * Created by Taranu on 25/04/15.
 */
public class Circle extends Shape {
    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {
        xPos = 1;
        yPos = 2;
        radius = 3;
    }

    public Circle(int radius) {
        this.radius = radius;
        xPos = 1;
        yPos = 2;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        radius = 3;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public int fillColor() {
        return super.color;
    }

    public void fillColor(int color) {
        super.setColor(color);
        System.out.println("The color is now " + super.color);
    }

    public void fillColor(float saturation) {
        super.setSaturation(saturation);
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "center = (" + xPos + "," + yPos + ") and radius =" + radius;
    }
}
