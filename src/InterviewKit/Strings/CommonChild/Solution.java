package InterviewKit.Strings.CommonChild;

import java.util.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        HashMap<Character, List<Integer>> s1Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1Arr[i];
            List<Integer> positionList = s1Map.getOrDefault(c, new ArrayList<>());
            positionList.add(i);
            s1Map.put(c, positionList);
        }
        char[] s2Arr = s2.toCharArray();
        List<List<Integer>> s2ListIndex = new ArrayList<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2Arr[i];
            if (s1Map.containsKey(c)) {
                s2ListIndex.add(s1Map.get(c));
            }
        }
        findMaxLength(s2ListIndex, 0);
        return maxLength;
    }

    static List<Integer> chosen = new LinkedList<>();
    static int maxLength = 0;

    public static void findMaxLength(List<List<Integer>> lists, int start) {
        if (start < lists.size()) {
            List<Integer> integers = lists.get(start);
            for (int index : integers) {
                //select
                if (chosen.size() == 0) {
                    tryAccept(lists, start, index);
                } else {
                    int max = chosen.get(chosen.size() - 1);
                    if (index > max) {
                        tryAccept(lists, start, index);
                    }
                }

            }
            findMaxLength(lists, start + 1);
        }
    }

    private static void tryAccept(List<List<Integer>> lists, int start, int index) {
        chosen.add(index);
        if (chosen.size() > maxLength) {
            maxLength = chosen.size();
        }
        findMaxLength(lists, start + 1);
        chosen.remove(new Integer(index));
    }

    public static void main(String[] args) {
        String s1 = "ELGGYJWKTDHLXJRBJLRYEJWVSUFZKYHOIKBGTVUTTOCGMLEXWDSXEBKRZTQUVCJNGKKRMUUBACVOEQKBFFYBUQEMYNENKYYGUZSP";
        String s2 = "FRVIFOVJYQLVZMFBNRUTIYFBMFFFRZVBYINXLDDSVMPWSQGJZYTKMZIPEGMVOUQBKYEWEYVOLSHCMHPAZYTENRNONTJWDANAMFRX";
        System.out.println(commonChild(s1, s2));
    }
}