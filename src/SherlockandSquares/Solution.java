package SherlockandSquares;

public class Solution {
    // Complete the squares function below.
    static int squares(int a, int b) {
        int start = (int) Math.floor(Math.sqrt(a));
        int end = (int) Math.floor(Math.sqrt(b));
        int count = 0;
        for (int i = start; i <= end; i++) {
            int temp = i * i;
            if (temp >= a && temp <=b) count++;
        }
        return count;
    }
}
