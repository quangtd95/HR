package CutTheSticks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 3, 3, 2, 1};
        int[] result = cutTheSticks(arr);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        List<Integer> result = new ArrayList<>();
        int remain = arr.length;
        while (i < arr.length) {
            if (remain != 0) {
                result.add(remain);
            }
            int same = 1;
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                same++;
                i++;
            }
            remain -= same;
            i++;
        }
        return result.stream().mapToInt(it -> it).toArray();
    }
}
