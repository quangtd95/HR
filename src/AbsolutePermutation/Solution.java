package AbsolutePermutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        Set<Integer> checkSet = new HashSet<>();
        boolean b = build(checkSet, a, 0, k);
        return b ? a : new int[]{-1};
    }

    private static boolean checkAbsPer(Set<Integer> temp, int[] a, int k) {
        System.out.println("checking...");
        println(a);
        for (int i = 0; i < a.length; i++) {
            int j = a[i];
            if (Math.abs(j - i - 1) != k) {
                return false;
            }
        }
        return temp.size() == a.length;
    }

    static boolean build(Set<Integer> tempSet, int[] a, int i, int k) {
        List<Integer> tempList = new ArrayList<>();
        if (k == 0) {
            tempList.add(i + 1);
        } else {
            if (i + 1 - k >= 1) {
                tempList.add(i + 1 - k);
            }
            if (i + 1 + k <= a.length) {
                tempList.add(i + 1 + k);
            }
        }
        for (Integer v : tempList) {
            if (tempSet.contains(v)) continue;
            a[i] = v;
            tempSet.add(v);
            if (i == a.length - 1) {
                if (checkAbsPer(tempSet, a, k)) {
                    return true;
                }
            } else {
                boolean result = build(tempSet, a, i + 1, k);
                tempSet.remove(v);
                if (result) return true;
            }
        }
        return false;
    }

    static void println(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] result = absolutePermutation(9331, 0);
        System.out.println("result...");
        println(result);
    }
}