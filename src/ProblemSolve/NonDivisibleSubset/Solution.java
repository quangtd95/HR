package ProblemSolve.NonDivisibleSubset;

import java.util.*;

public class Solution {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        /*
          khoi tao mang moi arr[i], arr[i] = count (s[j] % k = i)
         */
        int[] arr = new int[k];
        for (Integer e : s) {
            arr[e % k]++;
        }
        int result = 0;
        /*
        arr[0] là số lượng các phần từ chia hết cho k,
            nếu có nhiều hơn 1, thì chỉ đc thêm vào list result 1 phần tử duy nhất
         */
        result += Math.min(arr[0], 1);
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                result += Math.max(arr[i], arr[k - i]);
            } else {
                result += Math.min(arr[i], 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436);
        int k = 7;
//        for (Integer e : s) {
//            System.out.print(e % k);
//        }
        int result = nonDivisibleSubset(k, s);
        System.out.println(result);
    }

}
