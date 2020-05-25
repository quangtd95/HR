package JavaSkill.Java1DArrayPart2;

import java.util.Scanner;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        return isReachable(game, leap, 0);
    }
    public static boolean isReachable(int[] game, int leap, int i){
        if (i < 0 || game[i] == 1) return false;
        if (i == game.length - 1 || i + leap > game.length-1) return true;
        game[i] = 1;
        return isReachable(game,leap, i-1) || isReachable(game,leap,i+1) || isReachable(game,leap,i+leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}