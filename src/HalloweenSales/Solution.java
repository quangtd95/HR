package HalloweenSales;

public class Solution {
    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int remain = s;
        int price = p;
        int result = 0;
        while (remain >= price) {
            result++;
            remain -= price;
            price -= d;
            price = Math.max(price, m);
        }
        return result;
    }

}
