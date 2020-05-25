package JavaSkill.JavaPrimalityTest;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        BigInteger ni = new BigInteger(n);
        String result = ni.isProbablePrime(0) ? "prime" :"not prime";
        System.out.println(result);
        scanner.close();
    }

    public static boolean isPrime(BigInteger n) {
        int factors = 0;
        BigInteger max = n.divide(BigInteger.valueOf(2));
        for (BigInteger i = BigInteger.ONE; i.compareTo(max) <=0; i = i.add(BigInteger.ONE)) {
            if (n.mod(i).equals(BigInteger.ZERO))
                factors++;
        }
        return factors == 1;
    }
}
