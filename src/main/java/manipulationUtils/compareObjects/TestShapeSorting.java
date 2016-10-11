package manipulationUtils.compareObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nimrod Golan on 17/09/2016.
 */
public class TestShapeSorting {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 3);
        Rectangle rectangle2 = new Rectangle(1, 4);
        Rectangle rectangle3 = new Rectangle(2, 5);
        Rectangle rectangle4 = new Rectangle(3, 3);

        Circle c1 = new Circle(2);
        Circle c2 = new Circle(3);
        Circle c3 = new Circle(4);
        Circle c4 = new Circle(5);

        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(rectangle1);
        shapeList.add(rectangle2);
        shapeList.add(rectangle3);
        shapeList.add(rectangle4);
        shapeList.add(c1);
        shapeList.add(c2);
        shapeList.add(c3);
        shapeList.add(c4);

        Collections.sort(shapeList);
        System.out.println(shapeList);
    }
}
