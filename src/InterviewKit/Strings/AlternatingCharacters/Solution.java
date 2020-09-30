package InterviewKit.Strings.AlternatingCharacters;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "AAAA";
        System.out.println(alternatingCharacters(s));
    }
}