package MinimumDistances;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int distance = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            result.putIfAbsent(a[i], new ArrayList<>());
            List<Integer> indexList = result.get(a[i]);
            indexList.add(i);
            result.replace(a[i], indexList);
            if (indexList.size() > 1) {
                int newDistance = indexList.get(indexList.size() - 1) - indexList.get(indexList.size() - 2);
                if (newDistance < distance) {
                    distance = newDistance;
                }
            }
        }
        if (distance == Integer.MAX_VALUE) {
            return -1;
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
