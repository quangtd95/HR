package InterviewKit.MarkandToys;

import java.util.Arrays;

public class Solution {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int total = 0;
        int i = 0;
        while (total < k) {
            total += prices[i];
            i++;
        }
        return i;
    }
}