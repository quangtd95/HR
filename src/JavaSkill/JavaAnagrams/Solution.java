package JavaSkill.JavaAnagrams;


public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        a = a.toLowerCase();
        b = b.toLowerCase();
        java.util.HashMap<Character,Integer> countA = new java.util.HashMap<>();
        java.util.HashMap<Character,Integer> countB = new java.util.HashMap<>();

        for (char c : a.toCharArray()) {
            int current = countA.getOrDefault(c,0);
            countA.put(c,current+1);
        }
        for (char c : b.toCharArray()) {
            int current = countB.getOrDefault(c,0);
            countB.put(c,current+1);
        }


        for (Character c : countA.keySet()){
            if (!countB.containsKey(c)){
                return false;
            }
            int ca = countA.get(c);
            int cb = countB.get(c);
            if (ca != cb){
                return false;
            }
            countA.put(c,0);
            countB.put(c,0);
        }
        for (Character c : countB.keySet()){
            if (countB.get(c)>0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "anagram";
        String b = "margana";
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
