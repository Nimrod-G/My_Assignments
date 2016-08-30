package codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nimrod Golan on 24/08/2016.
 */
public class Distinct {

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        } else {
            Map<Integer, Integer> map = new HashMap<>();

            for (int element : A) {
                if (!map.containsKey(element)) {
                    map.put(element, 1);
                } else {
                    map.put(element, map.get(element) + 1);
                }
            }
            return map.size();
        }
    }
}
