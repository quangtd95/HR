package ProblemSolve.AbsolutePermutation;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution2 {
    //return 0: error
    static int getMinValue(int n, int i, int k) {
        int xMin = i + 1 - k;
        int xMax = i + 1 + k;
        if (xMin <= 0 && xMax >= n + 1) {
            return 0;
        }
        if (xMin <= 0 && xMax < n + 1) {
            return xMax;
        }
        return Math.min(xMin, xMax);
    }

    static int getMaxValue(int n, int i, int k) {
        int xMin = i + 1 - k;
        int xMax = i + 1 + k;
        if (xMax >= n + 1) {
            return xMin;
        }
        return Math.max(xMax, xMin);
    }

    static boolean canChange(int n, int i, int k) {
        return getMaxValue(n, i, k) != getMinValue(n, i, k);
    }

    static boolean cannotChange(int n, int i, int k) {
        return !canChange(n, i, k);
    }

    static int[] absolutePermutation(int n, int k) {
        if (k == 0) {
            return IntStream.range(1, n + 1).toArray();
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int value = getMinValue(n, i, k);
            if (value == 0) {
                return new int[]{-1};
            }
            a[i] = value;
        }
        Set<Integer> tempSet = new HashSet<>();
        if (checkAbsPer(tempSet, a, k)) {
            return a;
        }
        int firstMin;
        while (true) {
            firstMin = n - 1;
            while (firstMin > 0 && (cannotChange(n, firstMin, k) || a[firstMin] == getMaxValue(n, firstMin, k))) {
                firstMin--;
            }
            int i = firstMin;
            a[i] = getMaxValue(n, i, k);
            i++;
            while (i < n) {
                a[i] = getMinValue(n, i, k);
                i++;
            }
            if (checkAbsPer(tempSet, a, k)) {
                return a;
            }
            if (firstMin == 0 && a[firstMin] == getMaxValue(n, firstMin, k)) {
                return new int[]{-1};
            }
        }
    }

    private static boolean checkAbsPer(Set<Integer> temp, int[] a, int k) {
        temp.clear();
        for (int i = 0; i < a.length; i++) {
            int j = a[i];
            temp.add(j);
            if (Math.abs(j - i - 1) != k) {
                return false;
            }
        }
        return temp.size() == a.length;
    }

    static void println(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        /*String testcase = "12.txt";
        File file = new File("src/AbsolutePermutation/input" + testcase);
        File out = new File("src/AbsolutePermutation/my_output" + testcase);
        FileReader fileReader = new FileReader(file);
        FileOutputStream fileWriter = new FileOutputStream(out);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileWriter));
        String line;
        line = bufferedReader.readLine();
        int num = Integer.parseInt(line);
        for (int i = 0; i < num; i++) {
            line = bufferedReader.readLine();
            String[] input = line.split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int[] result = absolutePermutation(n, k);
            for (int j = 0; j < result.length; j++) {
                bufferedWriter.write(result[j] + "");
                if (j != result.length - 1) {
                    bufferedWriter.write(" ");
                    System.out.print(result[j] + "");
                }
            }
            if (i != num - 1) {
                bufferedWriter.newLine();
                System.out.println();
            }
        }
        bufferedReader.close();
        fileReader.close();
        bufferedWriter.close();
        fileWriter.close();*/
        for (int i = 0; i < 8; i++) {
            System.out.println(i + " - " + getMinValue(8, i, 2) + " - " + getMaxValue(8, i, 2));
        }
        int[] result = absolutePermutation(8, 2);

        System.out.println("result:");
        println(result);
    }
}
