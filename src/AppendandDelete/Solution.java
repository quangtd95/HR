package AppendandDelete;

public class Solution {
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        if (s.length() == t.length()) return "Yes";
        int length = Math.min(s.length(), t.length());
        int maxSameIndex = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                maxSameIndex = i;
                break;
            }
        }
        if (s.length() + t.length() - maxSameIndex * 2 == k) {
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) {
        String s = "aba";
        String t = "aba";
        int k = 7;
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
    }
}
