package ProblemSolve.BiggerisGreater;

public class Solution {
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        StringBuilder s = new StringBuilder(w);
        int n = s.length();
        int k, l;
        for (k = n - 2; k >= 0; k--) if (s.charAt(k) < s.charAt(k + 1)) break;
        if (k < 0) return "no answer";
        for (l = n - 1; l > k; l--) if (s.charAt(k) < s.charAt(l)) break;
        swap(s, k, l);
        for (int i = k + 1, j = n - 1; i < j; i++, j--) swap(s, i, j);
        return s.toString();
    }

    static void swap(StringBuilder s, int i, int j) {
        String tep = s.charAt(i) + "";
        s.replace(i, i + 1, s.charAt(j) + "");
        s.replace(j, j + 1, tep);

    }

    public static void main(String[] args) {
        String result = biggerIsGreater("dhck");
        System.out.println(result);
    }
}
