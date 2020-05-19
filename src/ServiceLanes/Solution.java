package ServiceLanes;

public class Solution {
    // Complete the serviceLane function below.
    static int[] serviceLane(int n, int[] width, int[][] cases) {
        int[] result = new int[cases.length];
        for (int i = 0; i < width.length; i++) {
            for (int j = 0; j < cases.length; j++) {
                if (cases[j][0] <= i && cases[j][1] >= i) {
                    if (result[j] == 0) {
                        result[j] = Integer.MAX_VALUE;
                    }
                    if (result[j] > width[i]) {
                        result[j] = width[i];
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] width = new int[]{2, 3, 1, 2, 3, 2, 3, 3};
        int[][] cases = new int[][]{
                {0, 3},
                {4, 6},
                {6, 7},
                {3, 5},
                {0, 7},
        };
        int[] result = serviceLane(width.length, width, cases);
        for (int r : result
        ) {
            System.out.println(r);
        }
    }
}
