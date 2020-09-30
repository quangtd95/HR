package ProblemSolve.ConnectedCellsinaGrid;

public class Solution {

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    int length = markAllCellConnected(matrix, i, j);
                    if (length > max) {
                        max = length;
                    }
                }
            }
        }
        return max;
    }

    static int[] di = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dj = new int[]{0, 0, 1, -1, 1, -1, 1, -1};

    static int markAllCellConnected(int[][] matrix, int i, int j) {
        if (i >= matrix.length) return 0;
        if (i < 0) return 0;
        if (j >= matrix[0].length) return 0;
        if (j < 0) return 0;
        int sum = 1;
        if (matrix[i][j] == 0) {
            return 0;
        } else {
            matrix[i][j] = 0;
            for (int k = 0; k < 8; k++) {
                sum += markAllCellConnected(matrix, i + di[k], j + dj[k]);
            }
        }
        return sum;
    }
}