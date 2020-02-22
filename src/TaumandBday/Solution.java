package TaumandBday;

import java.math.BigInteger;

public class Solution {
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        BigInteger result = new BigInteger("0");
        BigInteger B = new BigInteger(b + "");
        BigInteger W = new BigInteger(w + "");
        BigInteger BC = new BigInteger(bc + "");
        BigInteger WC = new BigInteger(wc + "");
        BigInteger Z = new BigInteger(z + "");

        if (bc > wc + z) {
            result = WC.multiply(W.add(B)).add(B.multiply(Z));
            return Long.parseLong(result.toString());
        }
        if (wc > bc + z) {
            result = BC.multiply(B.add(W)).add(W.multiply(Z));
            return Long.parseLong(result.toString());
        }
        result = B.multiply(BC).add(W.multiply(WC));
        return Long.parseLong(result.toString());
    }

    public static void main(String[] args) {
        int b = 27984;
        int w = 1402;
        int bc = 619246;
        int wc = 615589;
        int z = 247954;
        long result = taumBday(b, w, bc, wc, z);
        System.out.println(result);
        System.out.println(Long.MAX_VALUE);
    }
}
