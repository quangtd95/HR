package ProblemSolve.TheBombermanGame;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    static class Bomb {
        public int timeRemain = 3;
    }

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        Bomb[][] bombGrid = new Bomb[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                bombGrid[i][j] = new Bomb();
                if (grid[i].charAt(j) != 79) {
                    bombGrid[i][j].timeRemain = 0;
                }
            }
        }
        watchBomb(bombGrid);
        int target;
        if (n == 0) {
            return grid;
        } else if (n == 1) {
            return println(bombGrid);
        } else if (n % 2 == 0) {
            target = 2;
        } else if (n == 3) {
            target = 3;
        } else if ((n - 3) % 4 == 0) {
            target = 7;
        } else {
            target = 5;
        }

        int tick = 1;
        boolean generated = false;
        while (tick < target) {
            tick++;
            watchBomb(bombGrid);
            if (!generated) {
//                System.out.println("=======tick = " + tick + " generate");
                generateBomb(bombGrid);
                generated = true;
            } else {
//                System.out.println("=======tick = " + tick + " watch");
                generated = false;
            }
//            println(bombGrid);
        }
//        System.out.println("=====");
//        return println(bombGrid);
        return println(bombGrid);
    }

    static String[] println(Bomb[][] bombs) {
        String[] result = new String[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < bombs[0].length; j++) {
//                System.out.print(bombs[i][j].timeRemain != 0 ? bombs[i][j].timeRemain : ".");
                sb.append(bombs[i][j].timeRemain != 0 ? "O" : ".");
            }
//            System.out.println();
            result[i] = sb.toString();
        }
        return result;
    }


    static void generateBomb(Bomb[][] bombs) {
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs[0].length; j++) {
                if (bombs[i][j].timeRemain == 0) {
                    bombs[i][j].timeRemain = 3;
                }
            }
        }
    }

    static void watchBomb(Bomb[][] bombs) {
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs[0].length; j++) {
                Bomb bomb = bombs[i][j];
                if (bomb.timeRemain != 0) {
                    bomb.timeRemain -= 1;
                    if (bomb.timeRemain == 0) {
                        bombs[i][j].timeRemain = 0;
                        if (i > 0) {
                            if (bombs[i - 1][j].timeRemain != 1) {
                                bombs[i - 1][j].timeRemain = 0;
                            }
                        }
                        if (i < bombs.length - 1) {
                            if (bombs[i + 1][j].timeRemain != 1) {
                                bombs[i + 1][j].timeRemain = 0;
                            }
                        }
                        if (j > 0) {
                            if (bombs[i][j - 1].timeRemain != 1) {
                                bombs[i][j - 1].timeRemain = 0;
                            }
                        }
                        if (j < bombs[0].length - 1) {
                            if (bombs[i][j + 1].timeRemain != 1) {
                                bombs[i][j + 1].timeRemain = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(result[i]);
            System.out.print(result[i]);
            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
                System.out.println();
            }
        }

//        bufferedWriter.newLine();
        System.out.println();
//        bufferedWriter.close();

        scanner.close();
    }
}
