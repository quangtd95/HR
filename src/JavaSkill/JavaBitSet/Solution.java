package JavaSkill.JavaBitSet;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        BitSet B1 = new BitSet(n);
        BitSet B2 = new BitSet(n);
        for (int i = 0 ; i <m; i++){
            String cmdLine = scanner.nextLine();
            String[] cmdArr = cmdLine.split(" ");
            String cmd = cmdArr[0];
            int p1 = Integer.parseInt(cmdArr[1]);
            int p2 = Integer.parseInt(cmdArr[2]);
            switch (cmd){
                case "AND":
                    if (p1 < p2) {
                        B1.and(B2);
                    } else {
                        B2.and(B1);
                    }
                    break;
                case "OR":
                    if (p1 < p2) {
                        B1.or(B2);
                    } else {
                        B2.or(B1);
                    }
                    break;
                case "XOR":
                    if (p1 < p2) {
                        B1.xor(B2);
                    } else {
                        B2.xor(B1);
                    }
                    break;
                case "FLIP":
                   if (p1 == 1){
                       B1.flip(p2);
                   } else {
                       B2.flip(p2);
                   }
                    break;
                case "SET":
                    if (p1 == 1){
                        B1.set(p2);
                    } else {
                        B2.set(p2);
                    }
            }
            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }
    }
}