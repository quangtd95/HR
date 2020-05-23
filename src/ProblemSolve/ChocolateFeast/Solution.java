package ProblemSolve.ChocolateFeast;

public class Solution {
    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        int k = n / c;
        int r = k;
        int result = k;
        while (r >= m) {
            int newChocolate = r / m;
            r = r / m + r % m;
            result += newChocolate;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int c = 2;
        int m = 2;
        int result = chocolateFeast(n, c, m);
        System.out.println(result);
    }
}
