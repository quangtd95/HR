package InterviewKit.Arrays.LeftRotation;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        int beginIndex = d % a.length;
        int count = 0;
        for (int i = beginIndex; i < a.length; i++) {
            result[count] = a[i];
            count++;
        }
        for (int i = 0; i < beginIndex; i++) {
            result[count] = a[i];
            count++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotLeft(a, 4)));
    }
}
