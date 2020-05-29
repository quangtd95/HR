package ProblemSolve.TheTimeinWords;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {


    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        HashMap<Integer, String> vocabs = new HashMap<>();
        vocabs.put(1, "one");
        vocabs.put(2, "two");
        vocabs.put(3, "three");
        vocabs.put(4, "four");
        vocabs.put(5, "five");
        vocabs.put(6, "six");
        vocabs.put(7, "seven");
        vocabs.put(8, "eight");
        vocabs.put(9, "nine");
        vocabs.put(10, "ten");
        vocabs.put(11, "eleven");
        vocabs.put(12, "twelve");
        vocabs.put(13, "thirteen");
        vocabs.put(14, "fourteen");
        vocabs.put(15, "quarter");
        vocabs.put(16, "sixteen");
        vocabs.put(17, "seventeen");
        vocabs.put(18, "eighteen");
        vocabs.put(19, "nineteen");
        vocabs.put(20, "twenty");
        vocabs.put(21, "twenty one");
        vocabs.put(22, "twenty two");
        vocabs.put(23, "twenty three");
        vocabs.put(24, "twenty four");
        vocabs.put(25, "twenty five");
        vocabs.put(26, "twenty six");
        vocabs.put(27, "twenty seven");
        vocabs.put(28, "twenty eight");
        vocabs.put(29, "twenty nine");
        vocabs.put(30, "half");
        if (m == 0) {
            return vocabs.get(h) + " o' clock";
        }
        if (m <= 30) {
            return vocabs.get(m) + (m ==1 ? " minute" : (m != 15 && m !=30) ? " minutes" : "") + " past " + vocabs.get(h);
        } else {
            int s = 60 -m;
            return vocabs.get(s) + (s ==1 ? " minute" : (s != 15 && s != 30) ? " minutes" : "") + " to " + vocabs.get(h + 1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(scanner);

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);
        System.out.println(result);


        scanner.close();
    }
}
