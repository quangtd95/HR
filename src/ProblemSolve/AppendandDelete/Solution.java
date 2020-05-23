package ProblemSolve.AppendandDelete;

public class Solution {
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int i = 0;
        int max = Math.max(s.length(), t.length());
        while (i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        i--;
        if (i > 0) {
            if (s.length() != t.length()) {
                if (Math.abs(s.length() - t.length()) > k) {
                    return "No";
                }
            }
            if (k == max - i) {
                return "Yes";
            }
            if ((max - i - k) % 2 == 0) {
                return "Yes";
            }

        }
        if (s.length() + t.length() <= k) {
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) {
        String s = "hackerhappy";
        String t = "hackerrank";
        int k = 9;
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
    }
}
