package ProblemSolve.Encryption;

import java.util.Scanner;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int L = s.length();
        int row = (int) Math.floor(Math.sqrt(L));
        int col = (int) Math.ceil(Math.sqrt(L));
        int pos = 0;
        int count = 0;
        int countWord = 0;
        StringBuilder result = new StringBuilder();
        while (count < L) {
            result.append(s.charAt(pos));
            pos += col;
            if (pos >= L) {
                countWord++;
                pos = countWord;
                result.append(" ");
            }
            count++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = encryption("haveaniceday");
        System.out.println(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

   /* public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/
}
