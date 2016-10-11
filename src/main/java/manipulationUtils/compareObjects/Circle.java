package manipulationUtils.compareObjects;

/**
 * Created by Nimrod Golan on 17/09/2016.
 */
public class Circle extends Shape {

    private final String NAME = "C";
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return "Circle area is: " + getArea() + "\n";
    }
}
