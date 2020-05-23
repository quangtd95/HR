package JavaSkill.JavaMD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(line.getBytes());
        byte[] digest = md.digest();
        System.out.println(convertBytesToHex(digest));
    }
    public static String convertBytesToHex(byte[] bytes) {

        StringBuilder result = new StringBuilder();

        for (byte temp : bytes) {

            int decimal = (int) temp & 0xff;  // bytes widen to int, need mask, prevent sign extension

            String hex = Integer.toHexString(decimal);

            result.append(hex);

        }
        return result.toString();


    }
}