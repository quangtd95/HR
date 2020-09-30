package ProblemSolve.Pairs;

import java.util.HashSet;

public class Solution {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        int count = 0;
        HashSet<Integer> integers = new HashSet<>();
        for (int num : arr) {
            integers.add(num);
            int max = num + k;
            int min = num - k;
            if (integers.contains(max)) {
                count++;
            }
            if (integers.contains(min)) {
                count++;
            }
        }
        return count;
    }
}
