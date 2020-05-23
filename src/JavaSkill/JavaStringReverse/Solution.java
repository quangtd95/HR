package JavaSkill.JavaStringReverse;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        StringBuilder B = new StringBuilder();
        for (int i = A.length()-1; i>=0; i--){
            B.append(A.charAt(i));
        }
         String r = A.equals(B.toString())? "Yes":"No";
        System.out.println(r);
    }
}



