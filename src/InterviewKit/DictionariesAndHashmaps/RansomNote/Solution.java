package InterviewKit.DictionariesAndHashmaps.RansomNote;

import java.util.HashMap;

public class Solution {
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String s : magazine) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        for (String s : note) {
            int count = countMap.getOrDefault(s, 0);
            if (count == 0) {
                System.out.println("No");
                return;
            } else {
                countMap.put(s, count - 1);
            }
        }
        System.out.println("Yes");

    }

    public static void main(String[] args) {

    }
}
