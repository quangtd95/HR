package InterviewKit.Strings.SpecialStringAgain;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int count = 0;
        while (i < arr.length) {
            int j = i + 1;
            while (j < arr.length && arr[j] == arr[i]) {
                j++;
                count++;
            }
            int length = j - i;
            boolean checkRightPart = true;
            for (int l = j + 1; l <= j + length; l++) {
                if (l >= s.length()) {
                    checkRightPart = false;
                    break;
                }
                if (arr[l] != arr[i]) {
                    checkRightPart = false;
                    break;
                }
            }
            if (checkRightPart) {
                count++;
            }
            i++;
        }
        return count + n;
    }


    public static void main(String[] args) {
        long count = substrCount(4, "aaaa");
        System.out.println(count);
    }
}