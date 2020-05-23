package JavaSkill.JavaSubstringComparisons;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        for (int i = 0 ; i <= s.length() - k; i++){
            String temp = s.substring(i,i+k);
            if (smallest.isEmpty()){
                smallest = temp;
            } else if (smallest.compareTo(temp)>0) {
                smallest = temp;
            }
            if (largest.isEmpty()) {
                largest = temp;
            } else if (largest.compareTo(temp)<0){
                largest = temp;
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        String result = getSmallestAndLargest("welcometojava",3);
        System.out.println(result);
    }
}

