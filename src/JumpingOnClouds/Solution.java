package JumpingOnClouds;

public class Solution {
    static int jumpingOnClouds(int[] c, int k) {
        int e = 100;
        int i = 0;
        do {
            i += k;
            i %= c.length;
            if (c[i] == 1) {
                e -= 2;
            }
            e--;
        } while (i != 0);
        return e;
    }

    public static void main(String[] args) {
        int[] c = new int[]{0, 0, 1, 0, 0, 1, 1, 0};
        int k = 2;
        int result = jumpingOnClouds(c, k);
        System.out.println(result);
    }

}
