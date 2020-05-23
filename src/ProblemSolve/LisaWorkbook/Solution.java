package ProblemSolve.LisaWorkbook;

public class Solution {
    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int page = 1;
        int chapter = 0;
        int special = 0;
        int minProblem = 1;
        while (chapter < n) {
            printArr(arr);
            int addedProblems = Math.min(k, arr[chapter]);
            System.out.printf("add %d problems to page %s\n", addedProblems, page);
            System.out.printf("chapter %d\n", chapter + 1);
            System.out.printf("page: %d\n", page);
            if (minProblem <= page && minProblem + addedProblems > page) {
                special++;
            }
            arr[chapter] -= addedProblems;
            minProblem += addedProblems;
            if (arr[chapter] <= 0) {
                chapter++;
                minProblem = 1;
            }
            page++;
            System.out.println();
        }
        return special;
    }

    static void printArr(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] arr = new int[]{4, 2, 6, 1, 10};
        int result = workbook(n, k, arr);
        System.out.println(result);
    }
}
