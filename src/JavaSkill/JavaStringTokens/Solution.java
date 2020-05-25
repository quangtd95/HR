package JavaSkill.JavaStringTokens;

public class Solution {

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();
        // Write your code here.
        String s = "                        \n";
        if (s.trim().isEmpty()){
            System.out.println(0);
            return;
        }
        String[] results = s.trim().split("[ !,?._'@]+");
        System.out.println(results.length);
        for(String ss : results){
            if (!ss.isEmpty()){
                System.out.println(ss);
            }
        }
//        scan.close();
    }
}

