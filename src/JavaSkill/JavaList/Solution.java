package JavaSkill.JavaList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n; i++){
            list.add(scanner.nextInt());
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0 ; i < q; i++){
            String cmd = scanner.next();
            if (cmd.trim().equals("Insert")){
                int p1 = scanner.nextInt();
                int p2 = scanner.nextInt();
                list.add(p1,p2);
            }
            if (cmd.trim().equals("Delete")){
                int p1 = scanner.nextInt();
                list.remove(p1);
            }
        }
        for(int i : list){
            System.out.print(i+ " ");
        }
    }
}