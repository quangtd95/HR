package ProblemSolve.ModifiedKaprekarNumbers;

public class Solution {
    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        int count = 0;
        for (int i = p; i <= q; i++) {
            if (i == 77778) {
                System.out.println("DEBUG");
            }
            long n2 = (long)i * i;
            String n2Str = String.valueOf(n2);
            int d = 0;
            if (n2Str.length() % 2 == 0) {
                d = n2Str.length() / 2;
            } else {
                d = n2Str.length() / 2 + 1;
            }
            int firstPath = (int) (n2 / Math.pow(10, d));
            int secondPath = (int) (n2 % Math.pow(10, d));
            if (firstPath + secondPath == i) {
                count++;
                System.out.print(i + " ");
            }
        }
        if (count == 0) {
            System.out.print("INVALID RANGE");
        }
    }

    public static void main(String[] args) {
        kaprekarNumbers(1, 99999);
    }
}
