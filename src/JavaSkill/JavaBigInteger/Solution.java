package JavaSkill.JavaBigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here.
         Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String p1 = scanner.nextLine();
        String p2 = scanner.nextLine();
        BigInteger b1 = new BigInteger(p1);
        BigInteger b2 = new BigInteger(p2);
        System.out.println(b1.add(b2));
        System.out.println(b1.multiply(b2));
        scanner.close();
    }
}