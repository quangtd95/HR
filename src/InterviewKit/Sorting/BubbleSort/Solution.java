package InterviewKit.Sorting.BubbleSort;

public class Solution {
    static void sort(int[] a, int n) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[i] > a[j]) {
                    count++;
                    swap(a, i, j);
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.\n", count);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d\n", a[n - 1]);
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        sort(a, a.length);
    }

    public static void main(String[] args) {
        int n = 3;
        int[] a = new int[]{3, 2, 1};
        countSwaps(a);
    }
}
