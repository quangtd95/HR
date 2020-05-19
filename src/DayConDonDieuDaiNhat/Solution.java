package DayConDonDieuDaiNhat;

import java.util.Arrays;

/**
 * Cho dãy A1,A2,...,An. Hãy tìm một dãy con tăng có nhiều phần tử nhất của dãy.
 */
public class Solution {
    public static int execute(int[] input) {
        int[] results = new int[input.length];
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            results[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && results[i] < results[j] + 1) {
                    results[i] = results[j] + 1;
                }
            }
            if (results[i] > result) {
                result = results[i];
            }
        }
        int j = result;
        int[] resultDisplay = new int[j];
        for (int i = input.length - 1; i > 0; i--) {
            if (results[i] != j) {
                continue;
            }
            if (j == result || input[i] < resultDisplay[j]) {
                resultDisplay[j - 1] = input[i];
                j--;
            }
        }
        System.out.println(Arrays.toString(results));
        System.out.println(Arrays.toString(resultDisplay));
        return result;
    }


    public static void main(String[] args) {
        int[] input = new int[]{7, 4, 5, 6, 7, 74, 8, 8, 1, 9, 2};
//        int[] input = new int[]{1, 2, 3, 4, 1, 2, 3};
//        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        int result = execute(input);
        System.out.println(result);
    }
}
