package ProblemSolve.TheGridSearch;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        int r1 = G.length;
        int c1 = G[0].length();
        int r2 = P.length;
        int c2 = P[0].length();
        for (int i = 0; i <= r1 - r2; i++) {
            for (int j = 0; j <= c1 - c2; j++) {
                int r = i;
                boolean skip = false;
                for (int k = 0; k < r2; k++) {
                    if (G[r].substring(j, j + c2).equals(P[k])) {
                        r++;
                    } else {
                        skip = true;
                        break;
                    }
                }
                if (skip == false) {
                    return "YES";
                }

            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String[] G = new String[]{
                "123412",
                "561212",
                "123634",
                "781288",
        };
        String[] P = new String[]{
                "12",
                "34",

        };
        String result = gridSearch(G, P);
        System.out.println(result);
    }
}
