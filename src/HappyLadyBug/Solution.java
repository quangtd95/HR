package HappyLadyBug;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        boolean finish = b.length() > 1;
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            String c = b.charAt(i) + "";
            countMap.putIfAbsent(c, 0);
            int newCount = countMap.get(c) + 1;
            countMap.replace(c, newCount);
            if (finish && !c.equals(b.charAt(Math.min(i + 1, b.length() - 1)) + "") && !c.equals(b.charAt(Math.max(i - 1, 0)) + "")) {
                finish = false;
            }
        }
        int numberOfUnderScore = countMap.getOrDefault("_", 0);
        countMap.remove("_");
        //co' alone ladybug
        if (countMap.values().stream().anyMatch(it -> it == 1)) {
            return "NO";
        }
        //neu ko co underscore nao` , tru` truong hop board game da finish
        if (numberOfUnderScore == 0) {
            if (finish) {
                return "YES";
            }
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        String b = "GR";
        System.out.println(happyLadybugs(b));
    }
}
