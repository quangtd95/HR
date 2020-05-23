package JavaSkill.JavaRegex;

class Solution {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String IP = "555.12.12.034.2";
        String IP = "000.12.12.034";
//        while(in.hasNext()){
//            String IP = in.next();
        System.out.println(IP.matches(new MyRegex().pattern));
//        }

    }
}

class MyRegex {
    String zeroTo255 = "(\\d{1,2}|([01])\\d{2}|2[0-4]\\d|25[0-5])";
    public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
}
