package ViralAdvertising;

public class Solution {
    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int shared = 5;
        int liked;
        int cumulative = 0;
        for (int day = 1; day <= n; day++) {
            liked = shared / 2;
            cumulative += liked;
            shared = liked * 3;
        }
        return cumulative;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            int result = viralAdvertising(i);
            System.out.println("day " + i + ": " + result);
        }
    }
}
