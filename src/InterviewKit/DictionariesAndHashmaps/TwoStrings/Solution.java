package InterviewKit.DictionariesAndHashmaps.TwoStrings;

import java.util.HashSet;

public class Solution {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        HashSet<Character> cSet = new HashSet<>();
        for (char c : s1.toCharArray()) {
            cSet.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (cSet.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {

    }
}
