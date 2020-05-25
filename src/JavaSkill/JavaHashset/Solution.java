package JavaSkill.JavaHashset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        //Write your code here
     class Pair{
         String left;
         String right;
         Pair(String left,String right){
             this.left = left;
             this.right = right;
         }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;
             Pair pair = (Pair) o;
             return left.equals(pair.left) &&
                     right.equals(pair.right);
         }

         @Override
         public int hashCode() {
             return Objects.hash(left, right);
         }
     }
     HashSet<Pair> hashSet = new HashSet<>();
     for (int i = 0; i < t; i++) {
         Pair pair = new Pair(pair_left[i],pair_right[i]);
         hashSet.add(pair);
         System.out.println(hashSet.size());
     }

   }
}