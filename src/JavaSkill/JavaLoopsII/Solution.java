package JavaSkill.JavaLoopsII;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int sum = (int) (a + b * Math.pow(2,0));
            System.out.print(sum + " ");
            for (int j = 1; j < n; j++) {
                sum += b * Math.pow(2, j);
                System.out.print(sum + i != n - 1 ? " " : "");
            }
            System.out.println();
        }
        in.close();
    }
}