package Gojek;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int solve(List<Integer> inputData) {
        int count = 0;
        System.out.println(inputData);
        boolean[] result = new boolean[inputData.size()];
        for (int i : inputData) {
            boolean checkFlg = true;
            int index = i - 1;
            result[index] = true;
            for (int j = 0; j < index; j++) {
                checkFlg = checkFlg && result[j];
            }
            if (checkFlg) {
                count++;
            }
        }
        return count;
    }

    public static int solve2(List<Integer> inputData) {
        // declare the local variables

        int i, j, count = 0;

        boolean shines;


        // use the nested loops to count the number of moments for which every turned on bulb shines

        for (i = 0; i < inputData.size(); i++) {

            shines = true;

            for (j = i + 1; j < inputData.size() && shines; j++) {

                if (inputData.get(i) > inputData.get(j))

                    shines = false;

            }

            if (shines)

                count++;

        }

        // return the number of moments for which every turned on bulb shines

        return count;
    }


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(7, 3, 5, 4, 1, 6, 2);
        System.out.println(solve2(integers));
    }
}

class Result {

    /*
     * Complete the 'carParkingRoof' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_ARRAY cars
     *  2. INTEGER k
     */

    public static long carParkingRoof(List<Long> cars, int k) {
        Collections.sort(cars);
        long miniumLength = Long.MAX_VALUE;
        for (int i = 0; i <= cars.size() - k; i++) {
            long newLength = cars.get(i + k - 1) - cars.get(i);
            if (newLength < miniumLength) {
                miniumLength = newLength;
            }
        }
        return miniumLength + 1;
    }

}
