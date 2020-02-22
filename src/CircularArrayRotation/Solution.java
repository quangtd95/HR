package CircularArrayRotation;

public class Solution {
    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = (queries[i] - k ) % a.length;
            if (index <0) index = a.length+index;
            result[i] = a[index];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = circularArrayRotation(null, 0, null);
        System.out.println(result[0]);
    }
}
