package DayConCoTongBangS;

/**
 * Cho dãy A1,A2,...,AN. Tìm một dãy con của dãy đó có tổng bằng S.
 * <p>
 * Hướng dẫn:
 * <p>
 * Đặt L[i,t]=1 nếu có thể tạo ra tổng t từ một dãy con của dãy gồm các phần tử A1,A2,...,Ai. Ngược lại thì L[i,t]=0.
 * Nếu L[n,S]=1 thì đáp án của bài toán trên là “có”.
 * <p>
 * Ta có thể tính L[i,t] theo công thức: L[i,t]=1 nếu L[i−1,t]=1 hoặc L[i−1,t−a[i]]=1
 */
public class Solution {
    public static void process(int[] a, int s) {
        int[][] l = new int[a.length][s + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= s; j++) {
                if (i == 0) {
                    if (a[i] == j) {
                        l[i][j] = 1;
                    } else {
                        l[i][j] = 0;
                    }
                } else {
                    if (a[i] == j) {
                        l[i][j] = 1;
                    } else if (l[i - 1][j] == 1) {
                        l[i][j] = 1;
                    } else if (a[i] <= j && l[i - 1][j - a[i]] == 1) {
                        l[i][j] = 1;
                    } else {
                        l[i][j] = 0;
                    }
                }
            }
        }

        boolean result = l[a.length - 1][s] == 1;
        if (result) {
            //truy vet
            int sum = s;
            int i = a.length - 1;
            while (sum > 0 && i != -1) {
                System.out.println(a[i]);
                sum = sum - a[i];
                i = search(l, sum);
            }
        } else {
            System.out.println("khong co");
        }
    }

    public static int search(int[][] k, int s) {
        for (int i = 0; i < k.length; i++) {
            if (k[i][s] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int s = 16;
        process(a, s);
    }
}
