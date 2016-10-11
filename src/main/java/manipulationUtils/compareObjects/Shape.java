package manipulationUtils.compareObjects;

/**
 * Created by Nimrod Golan on 17/09/2016.
 */
public abstract class Shape implements Comparable<Shape> {

    public abstract double getArea();

    public abstract String getName();

    @Override
    public int compareTo(Shape o) {
        return (int) (this.getArea() - o.getArea());
    }
}
