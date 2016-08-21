package manipulationUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nimrod Golan on 11/08/2016.
 */
public class DuplicateInArray {

    public static List findAllDuplicates(int[] array) {
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int currentElement : array) {
            if (!myMap.containsKey(currentElement)) {
                myMap.put(currentElement, 0);
            } else {
                Integer value = myMap.get(currentElement);
                myMap.put(currentElement, value+1);
            }
        }

        List<Integer> duplicatedList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicatedList.add(entry.getKey());
            }
        }
        return duplicatedList;
    }

    public static void main(String[] args) {
        int[] myArray = new int[]{1,2,2,4,16,16,16,13,2,5,1};
        List allDuplicates = findAllDuplicates(myArray);
        int q = 0;
    }
}
