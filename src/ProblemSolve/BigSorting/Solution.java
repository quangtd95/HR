package ProblemSolve.BigSorting;

import java.io.*;
import java.util.Arrays;

public class Solution {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, (o1, o2) -> {
            if (o1.length() < o2.length()) {
                return -1;
            }
            if (o1.length() > o2.length()) {
                return 1;
            }
            return o1.compareTo(o2);
        });
        return unsorted;
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = reader.readLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        reader.close();
    }
}
