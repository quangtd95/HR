package JavaSkill.JavaArraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0 ; i < n; i++){
            int size = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++){
                list.add(scanner.nextInt());
            }
            lists.add(list);
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q;i++){
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            try{
                System.out.println(lists.get(p1-1).get(p2-1));
            }catch (Exception e){
                System.out.println("ERROR!");
            }
        }
    }
}