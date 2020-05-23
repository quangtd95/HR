package ProblemSolve.BeautifulTriplets;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        int count = 0;
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];
            int second = arr[i] + d;
            int last = arr[i] + 2 * d;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] > second) {
                    break;
                }
                if (arr[j] == second) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (arr[k] > last) {
                            break;
                        }
                        if (arr[k] == last) {
                            String result = i + "," + j + "," + k;
                            if (!resultSet.contains(result)) {
                                resultSet.add(result);
                                System.out.println(result);
                                count++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int d = 3;
        int[] arr = new int[]{1, 6, 7, 7, 8, 10, 12, 13, 14, 19};
        int result = beautifulTriplets(d, arr);
        System.out.println(result);
    }
}
