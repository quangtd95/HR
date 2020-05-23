package ProblemSolve.SurfaceArea3D;

import java.util.List;

public class Solution {
    private final int TOP = 0;
    private final int BOTTOM = 1;
    private final int LEFT = 2;
    private final int RIGHT = 3;
    private final int FRONT = 4;
    private final int BEHIND = 5;

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A) {
        int result = 0;
        int H = A.length;
        int W = A[0].length;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                result += 4 * A[i][j] + 2;
                if (i > 0) {
                    result -= Math.min(A[i - 1][j], A[i][j]) * 2;
                }
                if (j > 0) {
                    result -= Math.min(A[i][j - 1], A[i][j]) * 2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1}};
        int result = surfaceArea(A);
        System.out.println(result);
    }

}
