package ProblemSolve.AngryProfessor;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
        List<Integer> l = new ArrayList<>();
        for (int i : a) {
            l.add(i);
        }
        long present = l.stream().filter(integer -> integer <= 0).count();
        return present < k ? "YES" : "NO";
    }
}
