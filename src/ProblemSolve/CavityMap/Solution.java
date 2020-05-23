package ProblemSolve.CavityMap;

public class Solution {
    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0 && i < row - 1 && j > 0 && j < col - 1) {
                    int top = grid[i - 1].charAt(j);
                    int left = grid[i].charAt(j - 1);
                    int right = grid[i].charAt(j + 1);
                    int bottom = grid[i + 1].charAt(j);
                    int center = grid[i].charAt(j);
                    if (center > top && center > left && center > right && center > bottom) {
                        grid[i] = grid[i].substring(0, j) + "X" + grid[i].substring(j + 1, col);
                    }
                }
            }
        }
        return grid;
    }
}
