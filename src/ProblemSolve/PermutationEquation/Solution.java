package ProblemSolve.PermutationEquation;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            indexMap.put(p[i], i + 1);
        }
        int[] result = new int[p.length];
        for (int i = 1; i <= p.length; i++) {
            result[i - 1] = indexMap.get(indexMap.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] p = new int[]{4, 3, 5, 1, 2};
        int[] result = permutationEquation(p);
        for (int value : result) {
            System.out.print(value + " ");
        }

    }
}
