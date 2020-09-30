package InterviewKit.Strings.SherlockandtheValidString;

import java.util.HashMap;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            characterIntegerHashMap.put(c, characterIntegerHashMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Integer, Integer> countOfCounts = new HashMap<>();
        for (char c : characterIntegerHashMap.keySet()) {
            int count = characterIntegerHashMap.get(c);
            countOfCounts.put(count, countOfCounts.getOrDefault(count, 0) + 1);
            if (countOfCounts.size() > 2) {
                return "NO";
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (countOfCounts.keySet().size() == 1) {
            return "YES";
        }
        for (int c : countOfCounts.keySet()) {
            if (c < min) {
                min = c;
            }
            if (c > max) {
                max = c;
            }
        }
        if (countOfCounts.get(max) == 1 && max - min == 1) {
            return "YES";
        }
        if (countOfCounts.get(min) == 1){
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        System.out.println(isValid(s));
    }
}