package InterviewKit.Recursion.DavisStaircase;

public class Solution {

    // Complete the stepPerms function below.
    static int count = 0;

    static int stepPerms(int n) {
        count = 0;
        countSteps(n);
        return count;
    }

    static void countSteps(int n) {
        for (int i = 1; i <= 3; i++) {
            if (i <= n) {
                n -= i;
                if (n == 0) {
                    count++;
                }
                countSteps(n);
                n += i;
            }
        }
    }

    public static void main(String[] args) {
        int count = stepPerms(7);
        System.out.println(count);
    }
}
