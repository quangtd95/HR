package ProblemSolve.ManasaandStones;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {
        List<Integer> result = new ArrayList<>();
        for (int i = n - 1; i > -1; i--) {
            if (a < b)
                result.add((a * i) + (b * (n - 1 - i)));
//                System.out.print(((a*i)+(b*(n-1-i)))+" ");
            else if (a > b)
                result.add((b * i) + (a * (n - 1 - i)));
//                System.out.print(((b*i)+(a*(n-1-i)))+" ");
            else {
                result.add(((a * i) + (b * (n - 1 - i))));
//                System.out.print(((a*i)+(b*(n-1-i))));
                break;
            }
        }
        return result.stream().mapToInt(it -> it).toArray();
    }

    static void permutation(int[] arr, int a, int b) {
        for (int i = 0; i < arr.length; i++) {

        }
    }

    static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
