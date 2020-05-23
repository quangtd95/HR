package JavaSkill.JavaLambdaExpressions;

import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public static PerformOperation isOdd() {
        return a -> a % 2 == 1;
    }

    public static PerformOperation isPrime() {
        return MyMath::isPrime;
    }

    public static PerformOperation isPalindrome() {
        return MyMath::isPalindrome;
    }

    public static boolean isPalindrome(int n) {
        int r, sum = 0, temp;

        temp = n;
        while (n > 0) {
            r = n % 10;  //getting remainder
            sum = (sum * 10) + r;
            n = n / 10;
        }
        return temp == sum;
    }

    public static boolean isPrime(int n) {
        int factors = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) // ensure that you mod n not i
                factors++;
        }
        // if factors count is equals to 2 then it is prime number else it's not prime number
        return factors == 2;
    }

}
// Write your code here

public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
