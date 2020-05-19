package FairRations;

public class Solution {
    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        int lastID = -1;
        int count = 0;

        for (int i = 0; i < B.length; i++) {
            if (B[i] % 2 != 0) {
                if (lastID == -1) {
                    lastID = i;
                } else {
                    count += Math.abs(i - lastID) * 2;
                    lastID = -1;
                }
            }
        }
        if (lastID == -1) {
            return count;
        } else {
            return -1;
        }
    }
}
