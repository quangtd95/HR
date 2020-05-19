package Bomberman;

import java.util.stream.Stream;

public class Solution {
    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        if (n <= 1) return grid;
        if (n % 2 == 0) return fillUp(grid.length, grid[0].length());
        if ((n - 1) % 4 == 0) return grid;
        StringBuilder[] fullBombGrid = fillUpBuilder(grid.length, grid[0].length());
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'O') {
                    fullBombGrid[i].replace(j, j + 1, ".");
                    if (j > 0) {
                        fullBombGrid[i].replace(j - 1, j, ".");
                    }
                    if (j < chars.length - 1) {
                        fullBombGrid[i].replace(j + 1, j + 2, ".");
                    }
                    if (i > 0) {
                        fullBombGrid[i - 1].replace(j, j + 1, ".");
                    }
                    if (i < grid.length - 1) {
                        fullBombGrid[i + 1].replace(j, j + 1, ".");
                    }
                }
            }
        }
        return Stream.of(fullBombGrid).map(StringBuilder::toString).toArray(String[]::new);
    }

    public static StringBuilder[] fillUpBuilder(int r, int c) {
        StringBuilder[] grid = new StringBuilder[r];
        for (int i = 0; i < r; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < c; j++) {
                row.append("O");
            }
            grid[i] = row;
        }
        return grid;
    }

    public static String[] fillUp(int r, int c) {
        String[] grid = new String[r];
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < c; i++) {
            row.append("O");
        }
        for (int i = 0; i < r; i++) {
            grid[i] = row.toString();
        }
        return grid;
    }

    public static void main(String[] args) throws InterruptedException {
        String[] grid = new String[6];
        grid[0] = ".......";
        grid[1] = "...O...";
        grid[2] = "....O..";
        grid[3] = ".......";
        grid[4] = "OO.....";
        grid[5] = "OO.....";
        int n = 4;
      /*  for (int i = 0; i < 10; i++) {
            System.out.println("result n = " + i);
            String[] result = bomberMan(i, grid);
            for (String s : result) {
                System.out.println(s);
            }
            Thread.sleep(1000);
        }*/
        mock(grid);
    }

    static String[] mock(String[] grid) throws InterruptedException {
        int[][] grids = new int[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == 'O') {
                    grids[i][j] = 3;
                } else {
                    grids[i][j] = 0;
                }

            }
        }
        int n = 1;
        while (n < 100) {
            if (n == 1) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length(); j++) {
                        if (grids[i][j] != 0) {
                            grids[i][j] = grids[i][j] - 1;
                        }
                    }
                }
                println(grids, n);
            } else if (n % 2 == 0) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length(); j++) {
                        if (grids[i][j] == 0) {
                            grids[i][j] = 3;
                        } else {
                            grids[i][j] = grids[i][j] - 1;
                        }
                    }
                }
                println(grids, n);
            } else {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length(); j++) {
                        if (grids[i][j] != 0) {
                            grids[i][j] = grids[i][j] - 1;
                        }
                        if (grids[i][j] == 0) {
                            if (i > 0) {
                                grids[i - 1][j] = -1;
                            }
                            if (i < grids.length - 1) {
                                grids[i + 1][j] = -1;
                            }
                            if (j > 0) {
                                grids[i][j - 1] = -1;
                            }
                            if (j < grids[i].length - 1) {
                                grids[i][j + 1] = -1;
                            }
                        }

                    }
                }
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length(); j++) {
                        if (grids[i][j] == -1) {
                            grids[i][j] = 0;
                        }
                    }
                }

                println(grids, n);
            }
            n++;
            Thread.sleep(1000);
        }
        return null;
    }

    private static void println(int[][] grid, int n) {
        System.out.println("result n = " + n);
        for (int[] i : grid) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void println(String[] grid) {
        for (String i : grid) {
            System.out.print(i);
            System.out.println();
        }
    }

    // Complete the bomberMan function below.
    static String[] bomberMan2(int n, String[] grid) {
        String[] ans = new String[grid.length];
        int aa = grid[0].length();
        String ab = "";
        //String[] grd = new String(grid.length);
        for(int i=0;i<aa;i++){
            ab = ab.concat("0");
        }

        if(n%2 == 0){
            for(int i=0;i<grid.length;i++){
                ans[i] = ab;
            }
        }
        else{
            if(n==1){
                ans = grid;
            }
            else{
                int count = 0;
                while(count<2){
                    for(int i=0;i<grid.length;i++){
                        char[] tmp1 = grid[i].toCharArray();
                        for(int j=0;j<aa;j++){
                            if(tmp1[j] == 'O'){
                                tmp1[j] = '1';
                            }
                            else if(tmp1[j] == '.'){
                                tmp1[j] = 'O';
                            }
                        }
                        String ala = new String(tmp1);
                        grid[i]=ala;
                    }
                    int flag = 0;
                    int flag1 = 0;
                    for(int i=0;i<grid.length;i++){
                        char[] tmp = grid[i].toCharArray();
                        char[] tm2 = grid[i].toCharArray();
                        char[] tm3 = grid[i].toCharArray();
                        if(i-1 != -1){
                            tm2 = grid[i-1].toCharArray();
                        }
                        else{
                            flag = 1;
                        }
                        if(i+1 != grid.length){
                            tm3 = grid[i+1].toCharArray();
                        }
                        else{
                            flag1 = 1;
                        }
                        for(int j=0;j<aa;j++){
                            if(flag == 0 && flag1 == 0){
                                if(tmp[j] == '1'){
                                    tmp[j] = '.';
                                    if(j!=0){
                                        tmp[j-1] = '.';
                                    }
                                    if(j!=tmp.length-1){
                                        if(tmp[j+1] == 'O'){
                                            tmp[j+1] = '.';
                                        }
                                    }
                                    if(tm3[j] == 'O'){
                                        tm3[j] = '.';
                                    }
                                    if(tm2[j] == 'O'){
                                        tm2[j] = '.';
                                    }
                                }
                            }
                            else if(flag == 1 && flag1 == 0){
                                //flag = 0;
                                if(tmp[j] == '1'){
                                    tmp[j]='.';
                                    if(j!=0){
                                        tmp[j-1] = '.';
                                    }
                                    if(j!=tmp.length-1){
                                        if(tmp[j+1] == 'O'){
                                            tmp[j+1] = '.';
                                        }
                                    }
                                    if(tm3[j] == 'O'){
                                        tm3[j] = '.';
                                    }
                                }
                            }
                            else if(flag1 == 1 && flag == 0){
                                //flag1 = 0;
                                if(tmp[j] == '1'){
                                    tmp[j]='.';
                                    if(j!=0){
                                        tmp[j-1] = '.';
                                    }
                                    if(j!=tmp.length-1){
                                        if(tmp[j+1] == 'O'){
                                            tmp[j+1] = '.';
                                        }
                                    }
                                    if(tm2[j] == 'O'){
                                        tm2[j] = '.';
                                    }
                                }
                            }
                            else{
                                if(tmp[j] == '1'){
                                    tmp[j]='.';
                                    if(j!=0){
                                        tmp[j-1] = '.';
                                    }
                                    if(j!=tmp.length-1){
                                        if(tmp[j+1] == 'O'){
                                            tmp[j+1] = '.';
                                        }
                                    }
                                }
                            }
                        }
                        String a3 = new String(tmp);
                        grid[i] = a3;
                        if(flag == 0 && flag1 == 0){
                            String a1 = new String(tm2);
                            String a2 = new String(tm3);
                            grid[i-1] = a1;
                            grid[i+1] = a2;
                        }
                        else if(flag == 1 && flag1 == 0){
                            //String a1 = new String(tm2);
                            String a2 = new String(tm3);
                            grid[i+1] = a2;
                            flag = 0;
                        }
                        else if(flag == 0 && flag1 == 1){
                            String a1 = new String(tm2);
                            //String a2 = new String(tm3);
                            grid[i-1] = a1;
                            flag1 = 0;
                        }
                    }
                    count++;
                    ans = grid;
                    if((n+1)%4==0){
                        //grd = grid;
                        break;
                    }
                }
            }
        }
        return(ans);
    }
}
