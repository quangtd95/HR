package JavaSkill.JavaDequeue;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();
        HashSet<Integer> uniqueSet = new HashSet<>();
        HashMap<Integer,Integer> countMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (deque.size() < m) {
                deque.add(num);
                uniqueSet.add(num);
                int cur  = countMap.getOrDefault(num,0);
                countMap.put(num,cur + 1);
            }
            if (deque.size() == m) {
                if (max < uniqueSet.size()) {
                    max = uniqueSet.size();
                }
                int removed = deque.removeFirst();
                int cur = countMap.getOrDefault(removed,0);
                if (cur > 1){
                    countMap.put(removed,cur -1);
                } else {
                    countMap.put(removed,cur -1);
                    uniqueSet.remove(removed);
                }
            }
        }
        System.out.println(max);
    }
}



