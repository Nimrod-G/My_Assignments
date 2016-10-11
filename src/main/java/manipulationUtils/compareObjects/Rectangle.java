package manipulationUtils.compareObjects;

/**
 * Created by Nimrod Golan on 17/09/2016.
 */
public class Rectangle extends Shape {

    private final String NAME = "RECT";
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return "Rectangle area is: " + getArea() + "\n";
    }
}
