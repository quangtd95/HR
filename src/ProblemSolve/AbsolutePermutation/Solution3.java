package ProblemSolve.AbsolutePermutation;

import java.util.stream.IntStream;

public class Solution3 {
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

    static int[] absolutePermutation(int n, int k) {
        if (n % 2 == 0) {
            if (k > (n + 1) / 2) return error();
        } else {
            if (k >= (n + 1) / 2) return error();
        }

        if (k == 0) return IntStream.range(1, n + 1).toArray();
        int[] a = new int[n];
        boolean[] isUsed = new boolean[n + 1];
        int chosen = 0;
        for (int i = 0; i < k; i++) {
            int value = i + 1 + k;
            if (isUsed[value]) {
                return error();
            } else {
                a[i] = value;
                isUsed[value] = true;
                chosen++;
            }

        }
        for (int i = n - k; i < n; i++) {
            int value = i + 1 - k;
            if (isUsed[value]) {
                return error();
            } else {
                a[i] = value;
                chosen++;
                isUsed[value] = true;
            }
        }
        int surelyIndex = 0;
        int i = surelyIndex;
        int value;
        while (chosen != n) {
            value = a[i];
            int nextIndexEqualValue = findUsage(value, i, k, n);
            if (nextIndexEqualValue != -1) {
                int nextIdMinValue = getMinValue(n, nextIndexEqualValue, k);
                int nextIdMaxValue = getMaxValue(n, nextIndexEqualValue, k);
                int remainValue;
                if (value == nextIdMinValue) {
                    remainValue = nextIdMaxValue;
                } else {
                    remainValue = nextIdMinValue;
                }
                if (!isUsed[remainValue]) {
                    a[nextIndexEqualValue] = remainValue;
                    isUsed[remainValue] = true;
                    chosen++;
                } else {
                    return error();
                }
                i = nextIndexEqualValue;
            } else {
                //ko tim` thay so tuong tu de loai bo.
                surelyIndex = getNextSurelyIndex(surelyIndex, n, k);
                if (surelyIndex == -1) {
                    return error();
                }
                i = surelyIndex;
            }

        }
        return a;
    }

    static int getNextSurelyIndex(int index, int n, int k) {
//        1...k -> 0..k-1
//        n - k + 1... n -> n-k...n-1
        if (index < k - 1) {
            return index + 1;
        }
        if (index == k - 1) {
            return n - k;
        }
        if (index >= n-k) {
            return index + 1;
        }
        return -1;
    }

    static int findUsage(int value, int currentIndex, int k, int n) {
        int i1 = value - k - 1;
        if (i1 < 0) i1 = -1;
        int i2 = value + k - 1;
        if (i2 >= n) i2 = -1;
        if (i1 == currentIndex) {
            return i2;
        }
        return i1;
    }

    static int[] error() {
        return new int[]{-1};
    }

    static void println(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

  /*  public static void main(String[] args) throws IOException {
        String testcase = "02.txt";
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
        fileWriter.close();
    }*/

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        for (int i = 0; i < n; i++) {
            System.out.println(i + " - " + getMinValue(n, i, k) + " - " + getMaxValue(n, i, k));
        }
        int[] result = absolutePermutation(n, k);

        System.out.println("result:");
        println(result);
    }
}
