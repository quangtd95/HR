package Misc.SumArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = sum(a);
        System.out.println(sum);
        process();
    }

    public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void process() {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        for (int i = 2; i <= 9; i++) {
            List<String> temp = new ArrayList<>();
            for (String s : stringList) {
                temp.add(s + i);
                temp.add(s + " +" + i);
                temp.add(s + " -" + i);
            }
            stringList = temp;
        }

        stringList.stream()
                .filter(it -> 100 == Stream.of(it.split(" ")).mapToInt(Integer::parseInt).
                        reduce(Integer::sum).orElse(0)).forEach(System.out::println);

    }

    public static int sum(int[] array) {
        if (array.length == 1) {
            return array[0];
        } else {
            if (array.length > 1) {
                return array[0] + sum(Arrays.copyOfRange(array, 1, array.length));
            }
            return 0;
        }
    }
}
