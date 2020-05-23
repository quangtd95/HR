package ProblemSolve.EqualizetheArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        int maxCount = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value : arr) {
            if (countMap.get(value) == null) {
                countMap.put(value, 1);
            } else {
                countMap.replace(value, countMap.get(value) + 1);
            }
            maxCount = Math.max(countMap.get(value), maxCount);
        }
        return arr.length - maxCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 2, 1, 3};
        int result = equalizeArray(arr);
        System.out.println(result);
    }

}
