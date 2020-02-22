package FlatlandSpaceStations;

import java.util.Arrays;

public class Solution {
    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int spaceStationIndex = 0;
        int max = 0;
        int count = 0;
        int index = 0;
        while (index < n) {
            if (index == c[spaceStationIndex]) {
                count = 0;
            } else {
                count++;
            }
            if (count > max) {
                max = count;
            }
            index++;
        }
        return max;
    }

    public static void main(String[] args) {

        int n = 5;
        int[] station = new int[]{0, 4};
        int result = flatlandSpaceStations(n, station);
        System.out.println(result);
    }
}
