package ProblemSolve.LibraryFine;

public class Solution {
    public static void main(String[] args) {
    }

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2) {
            return 10000;
        } if (y1 == y2)  {
            if (m1 > m2) {
                return (m1 - m2) * 500;
            } else if (m1 == m2) {
                if (d1 > d2){
                    return (d1 - d2) * 15;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
