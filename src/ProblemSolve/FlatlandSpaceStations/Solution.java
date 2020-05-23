package ProblemSolve.FlatlandSpaceStations;

public class Solution {
    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int distance = Integer.MAX_VALUE;
            for (int value : c) {
                if (Math.abs(i - value) < distance) {
                    distance = Math.abs(i - value);
                }
            }
            if (distance > max) {
                max = distance;
            }
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
