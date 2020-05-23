package ProblemSolve.StrangeCounter;

public class Solution {
    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        long i = 1;
        long r = 3;
        while (i + r <= t) {
            i = i + r;
            r = r * 2;
        }
        return r - (t - i);
    }
}
