package InterviewKit.DictionariesAndHashmaps.SherlockandAnagrams;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int length = s.length();
        HashMap<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String text = s.substring(i, j + 1);
                String num = anagramsNumber(text);
                List<String> anagramsList = result.getOrDefault(num, new LinkedList<>());
                anagramsList.add(text);
                result.put(num, anagramsList);
            }
        }

        return result.keySet().stream()
                .map(it -> result.get(it).size())
                .filter(it -> it > 1)
                .reduce(0, (a, b) -> (a + (b - 1) * b / 2));
    }

    static String anagramsNumber(String s) {
        BigInteger sum = new BigInteger("0");
        BigInteger product = new BigInteger("1");

        for (char c : s.toCharArray()) {
            BigInteger temp = new BigInteger(((int) c) + "");
            sum = sum.add(temp);
            product = product.multiply(temp);
        }
        return product.multiply(sum).toString();
    }

    public static void main(String[] args) {
        int count = sherlockAndAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(count);
    }

}
