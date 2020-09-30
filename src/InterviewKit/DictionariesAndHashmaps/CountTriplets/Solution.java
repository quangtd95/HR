package InterviewKit.DictionariesAndHashmaps.CountTriplets;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        HashMap<Long, Long> arrMap = new HashMap<>();
        for (Long number : arr) {
            arrMap.put(number, arrMap.getOrDefault(number, 0L) + 1);
        }
        for (Long number : arrMap.keySet()) {
            long first = number;
            long second = number * r;
            long last = second * r;
            if (r == 1) {
                long n = arrMap.getOrDefault(first, 0L);
                if (n >= 3) {
                    count += (n - 2) * (n - 1) * n / 6;
                }
            } else {
                count += arrMap.getOrDefault(first, 0L) * arrMap.getOrDefault(second, 0L) * arrMap.getOrDefault(last, 0L);
            }
        }
        return count;
    }

    // Complete the countTriplets function below.
    static long countTriplets2(List<Long> arr, long r) {
        long total = 0;
        Map<Long, Long> count = new HashMap<>(); // count of ints
        Map<Long, Long> tuplets = new HashMap<>(); // map 2nd -> count of links

        for (long val : arr) {
            // inc total
            if (val % r == 0 && tuplets.containsKey(val / r)) {
                total += tuplets.get(val / r);
            }
            // create links/tuplets
            if (tuplets.containsKey(val)) {
                tuplets.put(val, tuplets.get(val) + count.get(val / r));
            } else if (val % r == 0 && count.containsKey(val / r)) {
                tuplets.put(val, count.get(val / r));
            }

            // inc count
            if (count.containsKey(val))
                count.put(val, count.get(val) + 1);
            else
                count.put(val, 1L);
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        List<Long> arr = new LinkedList<>();
        File file = new File("src/InterviewKit/DictionariesAndHashmaps/CountTriplets/input06.txt");
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int r = Integer.parseInt(firstLine[1]);
        reader.lines()
                .map(it -> it.split(" "))
                .flatMapToLong(strings -> Arrays.stream(strings).mapToLong(Long::parseLong))
                .forEach(arr::add);

        long result = countTriplets(arr, r);
        System.out.println(result);
    }
}