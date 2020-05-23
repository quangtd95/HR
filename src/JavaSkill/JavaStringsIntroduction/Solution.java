package JavaSkill.JavaStringsIntroduction;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        A = A.substring(0,1).toUpperCase() + A.toLowerCase().substring(1,A.length());
        B = B.substring(0,1).toUpperCase() + B.toLowerCase().substring(1,B.length());
        System.out.println(A + " " + B);

    }
}



