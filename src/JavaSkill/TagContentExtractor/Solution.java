package JavaSkill.TagContentExtractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public final static String CONTENT_TAG = "(<[^/<>]+>)(.+)(</[^<>]+>)";

    public static void main2(String[] args){
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());

        while (testCases-- > 0) {
            String line = scan.nextLine();

            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();
            parseXml(line);
            testCases--;
        }
    }

    public static void parseXml(String s) {
        List<String> tagList = getTagList(s);
        if (tagList.isEmpty()) {
            System.out.println("None");
        }
        if (!isBalanced(tagList)) {
            System.out.println("None");
        } else {
            printContent(s);
        }
    }

    public static void printContent(String s) {
        List<String> subTags = getSubTags(s);
        if (subTags.size() > 0) {
            for (String tag : subTags) {
                printContent(tag);
            }
        } else {
            System.out.println(getTagContent(s));
        }
    }

    public static String getTagName(String tag) {
        Pattern p = Pattern.compile("[^/^<^>]+");
        Matcher m = p.matcher(tag);
        if (m.find()) {
            return m.group();
        }
        return "";
    }

    public static String getTagContent(String s) {
        Pattern p = Pattern.compile(CONTENT_TAG);
        Matcher m = p.matcher(s);
        if (m.find()) {
            return m.group(2);
        }
        return "";
    }

    public static List<String> getTagList(String s) {
        String tagPattern = "(<[^[<>/]]+>)|(</[^<^>]+>)";
        Pattern tagP = Pattern.compile(tagPattern);
        Matcher tagMatcher = tagP.matcher(s);
        List<String> tagList = new ArrayList<>();
        while (tagMatcher.find()) {
            String tag = tagMatcher.group();
            tagList.add(tag);
        }
        return tagList;
    }

    public static boolean isPairTag(String tag1, String tag2) {
        String tag1Name = getTagName(tag1);
        String tag2Name = getTagName(tag2);
        if (tag1Name.equals(tag2Name)) {
            return tag2.contains("/");
        }
        return false;
    }

    public static String getTagFromTo(String s, List<String> tagList, int indexOpenTag, int indexCloseTag) {
        String result = s;
        int firstIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < tagList.size(); i++) {
            String tag = tagList.get(i);
            if (i < indexOpenTag) {
                firstIndex = s.indexOf(tag, firstIndex) + tag.length();
            }
            if (i <= indexCloseTag) {
                lastIndex = s.indexOf(tag, lastIndex) + tag.length();
            }
        }
        result = result.substring(firstIndex, lastIndex);
        return result;
    }

    public static List<String> getSubTags(String s) {
        List<String> result = new ArrayList<>();
        List<String> tagList = getTagList(s);
        Stack<String> tagStack = new Stack<>();
        if (tagList.size() == 0) {
            return result;
        }
        int indexOpenTag = 0;
        if (isPairTag(tagList.get(0), tagList.get(tagList.size() - 1))) {
            indexOpenTag = 1;
        }

        for (int i = indexOpenTag; i < tagList.size(); i++) {
            String tag = tagList.get(i);
            if (tagStack.isEmpty()) {
                tagStack.push(tag);
            } else {
                String lastTag = tagStack.peek();
                if (isPairTag(lastTag, tag)) {
                    tagStack.pop();
                } else {
                    tagStack.push(tag);
                }
            }
            if (tagStack.size() == 0) {
                result.add(getTagFromTo(s, tagList, indexOpenTag, i));
                indexOpenTag = i + 1;
            }
        }
        return result;
    }

    public static boolean isBalanced(List<String> s) {
        Stack<String> tagStack = new Stack<>();
        if (s.size() == 0) {
            return true;
        }
        for (String c : s) {
            c = getTagName(c);
            if (tagStack.isEmpty()) {
                tagStack.push(c);
            } else {
                String lastChar = tagStack.peek();
                if (lastChar.equals(c)) {
                    tagStack.pop();
                } else {
                    tagStack.push(c);
                }
            }
        }
        return tagStack.size() == 0;
    }
}



