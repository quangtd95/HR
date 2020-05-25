package JavaSkill.JavaSubarray;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int count =0;
        for (int i = 0 ; i < n; i++){
            for (int j = i; j<n; j++){
                int sum = 0;
                for (int t = i; t <= j; t++){
                    sum += arr[t];
                }
                if (sum <0) {
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}