package JavaSkill.JavaEndOfFile;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while(scanner.hasNext()){
            i++;
            System.out.println(i + " " +scanner.nextLine());
        }
        scanner.close();
    }
}