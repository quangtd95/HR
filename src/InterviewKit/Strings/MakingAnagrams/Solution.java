package InterviewKit.Strings.MakingAnagrams;

import java.util.HashMap;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int count = 0;
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();
        for (char ac : a.toCharArray()) {
            aMap.put(ac, aMap.getOrDefault(ac, 0) + 1);
        }
        for (char bc : b.toCharArray()) {
            bMap.put(bc, bMap.getOrDefault(bc, 0) + 1);
        }
        for (char x = 'a'; x <= 'z'; x++) {
            int countXinA = aMap.getOrDefault(x, 0);
            int countXinB = bMap.getOrDefault(x, 0);
            count += Math.abs(countXinA - countXinB);
        }
        return count;
    }
}