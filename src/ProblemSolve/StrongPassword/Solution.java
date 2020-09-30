package ProblemSolve.StrongPassword;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        final String regex1 = "[a-z]";
        final String regex2 = "[A-Z]";
        final String regex3 = "[0-9]";
        final String regex4 = "[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+]";
        int additionalCount = 0;
        if (!isMatched(regex1, password)) additionalCount++;
        if (!isMatched(regex2, password)) additionalCount++;
        if (!isMatched(regex3, password)) additionalCount++;
        if (!isMatched(regex4, password)) additionalCount++;
        if (n + additionalCount < 6) {
            additionalCount += (6 - n - additionalCount);
        }
        return additionalCount;
    }

    static boolean isMatched(String regex, String password) {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(password);
        return (matcher.find());
    }

    public static void main(String[] args) {
        String password= "AUzs-nV";
        System.out.println(minimumNumber(password.length(),password));
    }
}