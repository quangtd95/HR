package QueenAttackII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private enum Direction {
        UP, DOWN, LEFT, RIGHT, UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int up = n - r_q;
        int down = r_q - 1;
        int left = c_q - 1;
        int right = n - c_q;
        int upLeft = Math.min(up, left);
        int upRight = Math.min(up, right);
        int downLeft = Math.min(down, left);
        int downRight = Math.min(down, right);
        int result;
        Map<Direction, Integer[]> nearestObstacleMap = new HashMap<>();
        result = up + down + left + right + upLeft + upRight + downLeft + downRight;
        for (int i = 0; i < k; i++) {
            int r_o = obstacles[i][0];
            int c_o = obstacles[i][1];
            Direction d = checkObstaclesIn(r_q, c_q, r_o, c_o);
            if (d != null) {
                nearestObstacleMap.putIfAbsent(d, new Integer[]{r_o, c_o});
                Integer[] nearestObstacle = nearestObstacleMap.get(d);
                int distanceNewObstacle = Math.min(Math.abs(r_o - r_q) - 1, Math.abs(c_o - c_q) - 1);
                switch (d) {
                    case UP:
                        if (nearestObstacle[0] <= r_o) {
                            nearestObstacleMap.replace(d, new Integer[]{r_o, c_o});
                            result = result - up;
                            up = r_o - r_q - 1;
                            result += up;
                        }
                        break;
                    case DOWN:
                        if (nearestObstacle[0] >= r_o) {
                            nearestObstacleMap.replace(d, new Integer[]{r_o, c_o});
                            result = result - down;
                            down = r_q - r_o - 1;
                            result += down;
                        }
                        break;
                    case LEFT:
                        if (nearestObstacle[1] <= c_o) {
                            nearestObstacleMap.replace(d, new Integer[]{r_o, c_o});
                            result = result - left;
                            left = c_q - c_o - 1;
                            result += left;
                        }
                        break;
                    case RIGHT:
                        if (nearestObstacle[1] >= c_o) {
                            nearestObstacleMap.replace(d, new Integer[]{r_o, c_o});
                            result = result - right;
                            right = c_o - c_q - 1;
                            result += right;
                        }
                        break;
                    case UP_LEFT:
                        if (nearestObstacle[0] >= r_o || nearestObstacle[1] <= c_o) {
                            nearestObstacleMap.replace(d, new Integer[]{r_o, c_o});
                            result -= upLeft;
                            upLeft = distanceNewObstacle;
                            result += upLeft;
                        }
                        break;
                    case UP_RIGHT:
                        if (nearestObstacle[0] >= r_o || nearestObstacle[1] >= c_o) {
                            nearestObstacleMap.replace(d, new Integer[]{r_o, c_o});
                            result -= upRight;
                            upRight = distanceNewObstacle;
                            result += upRight;
                        }
                        break;
                    case DOWN_LEFT:
//                        if (nearestObstacle != null) {
                        if (nearestObstacle[0] <= r_o || nearestObstacle[1] <= c_o) {
                            nearestObstacleMap.replace(d, new Integer[]{r_o, c_o});
                            result -= downLeft;
                            downLeft = distanceNewObstacle;
                            result += downLeft;
                        }
                        break;
                    case DOWN_RIGHT:
                        nearestObstacleMap.put(d, new Integer[]{r_o, c_o});
                        if (nearestObstacle[0] <= r_o || nearestObstacle[1] >= c_o) {
                            nearestObstacleMap.replace(d, new Integer[]{r_o, c_o});
                            result -= downRight;
                            downRight = distanceNewObstacle;
                            result += downRight;
                        }
                        break;
                }
            }
        }
        return result;
    }

    private static Direction checkObstaclesIn(int r_q, int c_q, int r_o, int c_o) {
        if (r_q == r_o) {
            if (c_q > c_o) return Direction.LEFT;
            if (c_q < c_o) return Direction.RIGHT;
        }
        if (c_q == c_o) {
            if (r_q > r_o) return Direction.DOWN;
            if (r_q < r_o) return Direction.UP;
        }
        if (Math.abs(c_o - c_q) == Math.abs(r_o - r_q)) {
            if (r_o > r_q && c_o < c_q) return Direction.UP_LEFT;
            if (r_o > r_q && c_o > c_q) return Direction.UP_RIGHT;
            if (r_o < r_q && c_o < c_q) return Direction.DOWN_LEFT;
            if (r_o < r_q && c_o > c_q) return Direction.DOWN_RIGHT;
        }
        return null;
    }

    public static void main(String[] args) {
        int n = 100;
        int r_q = 48;
        int c_q = 81;
        int[][] obstacles = new int[][]{
                {54, 87},
                {64, 97},
                {42, 75},
                {32, 65},
                {42, 87},
                {32, 97},
                {54, 75},
                {64, 65},
                {48, 87},
                {48, 75},
                {54, 81},
                {42, 81},
                {45, 17},
                {14, 24},
                {35, 15},
                {95, 64},
                {63, 87},
                {25, 72},
                {71, 38},
                {96, 97},
                {16, 30},
                {60, 34},
                {31, 67},
                {26, 82},
                {20, 93},
                {81, 38},
                {51, 94},
                {75, 41},
                {79, 84},
                {79, 65},
                {76, 80},
                {52, 87},
                {81, 54},
                {89, 52},
                {20, 31},
                {10, 41},
                {32, 73},
                {83, 98},
                {87, 61},
                {82, 52},
                {80, 64},
                {82, 46},
                {49, 21},
                {73, 86},
                {37, 70},
                {43, 12},
                {94, 28},
                {10, 93},
                {52, 25},
                {50, 61},
                {52, 68},
                {52, 23},
                {60, 91},
                {79, 17},
                {93, 82},
                {12, 18},
                {75, 64},
                {69, 69},
                {94, 74},
                {61, 61},
                {46, 57},
                {67, 45},
                {96, 64},
                {83, 89},
                {58, 87},
                {76, 53},
                {79, 21},
                {94, 70},
                {16, 10},
                {50, 82},
                {92, 20},
                {40, 51},
                {49, 28},
                {51, 82},
                {35, 16},
                {15, 86},
                {78, 89},
                {41, 98},
                {70, 46},
                {79, 79},
                {24, 40},
                {91, 13},
                {59, 73},
                {35, 32},
                {40, 31},
                {14, 31},
                {71, 35},
                {96, 18},
                {27, 39},
                {28, 38},
                {41, 36},
                {31, 63},
                {52, 48},
                {81, 25},
                {49, 90},
                {32, 65},
                {25, 45},
                {63, 94},
                {89, 50},
                {43, 41}
        };
        int k = obstacles.length;
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
//        printChess(n, r_q, c_q, obstacles);
    }

    static void printChess(int n, int r_q, int c_q, int[][] obstacles) {
        String[][] chess = new String[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                chess[i][j] = "__";

            }
        }
        for (int[] obstacle : obstacles) {
            chess[obstacle[0]][obstacle[1]] = "XX";
        }
        chess[r_q][c_q] = "QQ";
        for (int i = n; i >= 1; i--) {
            System.out.print(String.format("%2d", i) + "|");
            for (int j = 1; j <= n; j++) {
                System.out.print(chess[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(String.format("%2d", i) + "|");
        }
    }
}
