package ProblemSolve.DesignerPDFViewer;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        int length = word.length();
        int maxHeight = 0;
        for (int i = 0; i < length; i++) {
            int indexHeight = getIndex(word.charAt(i));
            if (h[indexHeight] > maxHeight) {
                maxHeight = h[indexHeight];
            }
        }
        return maxHeight * length;
    }

    static int getIndex(char c) {
        return c - 97;
    }

    public static void main(String[] args) {
        String word = "abc";
        for (int i = 0; i < word.length(); i++) {
            System.out.println((int) word.charAt(i) - 97);
        }
        int[] h = new int[]{1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        int result = designerPdfViewer(h,word);
        System.out.println(result);
    }
}
