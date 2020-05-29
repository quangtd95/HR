package ProblemSolve.EmasSupercomputer;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {

        Plus maxPlus1 = null;
        Plus maxPlus2 = null;

        int n = grid.length;
        int m = grid[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == 'G') {
                    int top = i, bottom = i, left = j, right = j;
                    while (top > 0 && grid[top - 1].charAt(j) == 'G') {
                        top--;
                    }
                    while (bottom < n - 1 && grid[bottom + 1].charAt(j) == 'G') {
                        bottom++;
                    }
                    while (left > 0 && grid[i].charAt(left - 1) == 'G') {
                        left--;
                    }
                    while (right < m - 1 && grid[i].charAt(right + 1) == 'G') {
                        right++;
                    }
                    int minHeight = Math.min(i - top, bottom - i);
                    int minWidth = Math.min(j - left, right - j);
                    Plus currentPlus = new Plus(i, j, Math.min(minHeight, minWidth));
                    //chua co max1,max2
                    if (maxPlus1 == null && maxPlus2 == null) {
                        maxPlus1 = currentPlus;
                    } else
                        //moi co max1
                        if (maxPlus1 != null && maxPlus2 == null) {
                            //neu current > max1
                            //neu current ko overlap max1 => max2 = max1, max1 = current
                            //neu current overlap max1 => max1 = current
                            if (currentPlus.getArea() >= maxPlus1.getArea()) {
                                if (!currentPlus.intersect(maxPlus1)) {
                                    maxPlus2 = maxPlus1;
                                    maxPlus1 = currentPlus;
                                } else {
                                    maxPlus1 = currentPlus;
                                }
                            } else {
                                //neu current < max1
                                //neu current ko overlap max1 => max2 = current
                                //neu current overlap max1 => bo qua
                                if (currentPlus.getArea() <= maxPlus1.getArea()) {
                                    if (!currentPlus.intersect(maxPlus1)) {
                                        maxPlus2 = currentPlus;
                                    }
                                }
                            }
                        } else {
                            //co max1,max2
                            if (currentPlus.getArea() > maxPlus2.getArea()) {
                                if (!currentPlus.intersect(maxPlus1)) {
                                    maxPlus2 = currentPlus;
                                }
                            }
                            if (maxPlus1.getArea() < maxPlus2.getArea()) {
                                Plus temp = maxPlus1;
                                maxPlus1 = maxPlus2;
                                maxPlus2 = temp;
                            }
                        }
                }
            }
        }
        return( maxPlus1 == null ? 0 : maxPlus1.getArea()) * (maxPlus2 == null ? 0 : maxPlus2.getArea());
    }

    static class Plus {
        public int x;
        public int y;
        public int width;

        public Plus(int x, int y, int width) {
            this.x = x;
            this.y = y;
            this.width = width;
        }

        public int getArea() {
            return width * 4 + 1;
        }

        public boolean intersect(Plus other) {
            int myTop = x - width;
            int myBottom = x + width;
            int myLeft = y - width;
            int myRight = y + width;
            int otherTop = other.x - other.width;
            int otherBottom = other.x + other.width;
            int otherLeft = other.y - other.width;
            int otherRight = other.y + other.width;
            if (myTop <= other.x && myBottom >= other.x) {
                if (otherLeft <= y && y <= otherRight) {
                    return true;
                }
            }
            if (myLeft <= other.y && myRight >= other.y) {
                if (otherTop <= x && otherBottom >= x) {
                    return true;
                }
            }
            return false;
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);
        System.out.print(String.valueOf(result));
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
        System.out.println();
//        bufferedWriter.close();

        scanner.close();
    }
}
