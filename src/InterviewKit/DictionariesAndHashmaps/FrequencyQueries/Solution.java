package InterviewKit.DictionariesAndHashmaps.FrequencyQueries;

import java.util.*;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> mapIntToCount = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (List<Integer> integers : queries) {
            int query = integers.get(0);
            int value = integers.get(1);
            switch (query) {
                case 1:
                    int oldCount = mapIntToCount.getOrDefault(value, 0);
                    int newCount = oldCount + 1;
                    if (oldCount != 0) {
                        int newOfOldCount = countMap.getOrDefault(oldCount, 0) - 1;
                        if (newOfOldCount <= 0) {
                            countMap.remove(oldCount);
                        } else {
                            countMap.put(oldCount, newOfOldCount);
                        }
                    }
                    countMap.put(newCount, countMap.getOrDefault(newCount, 0) + 1);
                    mapIntToCount.put(value, mapIntToCount.getOrDefault(value, 0) + 1);
                    break;
                case 2:
                    oldCount = mapIntToCount.getOrDefault(value, 0);
                    newCount = oldCount - 1;
                    if (newCount < 0) newCount = 0;
                    countMap.put(oldCount, countMap.getOrDefault(oldCount, 0) - 1);
                    countMap.put(newCount, countMap.getOrDefault(newCount, 0) + 1);
                    mapIntToCount.put(value, newCount);
                    break;
                case 3:
                    if (countMap.getOrDefault(value, 0) == 0) {
                        result.add(0);
                    } else {
                        result.add(1);
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();

        queries.add(Arrays.asList(1, 5));
        queries.add(Arrays.asList(1, 6));
        queries.add(Arrays.asList(3, 2));
        queries.add(Arrays.asList(1, 10));
        queries.add(Arrays.asList(1, 10));
        queries.add(Arrays.asList(1, 6));
        queries.add(Arrays.asList(2, 5));
        queries.add(Arrays.asList(3, 2));
        System.out.println(freqQuery(queries));
    }
}