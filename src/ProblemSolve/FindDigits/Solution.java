package ProblemSolve.FindDigits;

public class Solution {
    static int findDigits(int n) {
        int result = 0;
        String ns = n + "";
        for (int i = 0; i < ns.length(); i++) {
            int j = ns.charAt(i) - 48;
            if (j != 0 && n % j == 0) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1012;
        int result = findDigits(n);
        System.out.println(result);
    }
}
