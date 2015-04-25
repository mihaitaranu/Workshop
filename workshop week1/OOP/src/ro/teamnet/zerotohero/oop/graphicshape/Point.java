package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Taranu on 25/04/15.
 */
public class Point {
    private int xPos;
    private int yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Point) {
            Point anotherPoint = (Point) obj;
            if (xPos == anotherPoint.xPos && yPos == anotherPoint.yPos) return true;
        }
        return false;
    }
}
