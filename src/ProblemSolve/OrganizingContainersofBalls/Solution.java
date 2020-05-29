package ProblemSolve.OrganizingContainersofBalls;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int[] numberOfEachContainer = new int[container.length];
        int[] numberOfEachBallType = new int[container.length];
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container.length; j++) {
                numberOfEachContainer[i] += container[i][j];
                numberOfEachBallType[j] += container[i][j];
            }
        }
        String result = "Possible";
        for (int i = 0; i < container.length; i++) {
            int j = 0;
            for (j = i; j < container.length; j++) {
                if (numberOfEachContainer[i] == numberOfEachBallType[j]) {
                    int temp = numberOfEachBallType[i];
                    numberOfEachBallType[i] = numberOfEachBallType[j];
                    numberOfEachBallType[j] = temp;
                    break;
                }
                if (j == container.length-1){
                    result = "Impossible";
                    return result;
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
