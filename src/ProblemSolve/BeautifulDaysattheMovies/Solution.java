package ProblemSolve.BeautifulDaysattheMovies;

public class Solution {
    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int result = 0;
        for (int x = i; x <= j; x++) {
            if (Math.abs(x - reverseInt(x)) % k == 0) {
                result++;
            }
        }
        return result;
    }

    static int reverseInt(int aa) {
        int a = aa;
        int result = 0;
        while (a != 0) {
            int r = a % 10;
            result = result * 10 + r;
            a = a / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = 20;
        int j = 23;
        int k = 6;
        int result = beautifulDays(i, j, k);
        System.out.println(result);
    }
}
