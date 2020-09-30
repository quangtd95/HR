package InterviewKit.Sorting.FraudulentActivityNotifications;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        int median;
        ArrayList<Integer> trailingDays = new ArrayList<>();
        for (int i = 0; i < expenditure.length; i++) {
            int spend = expenditure[i];
            if (i >= d) {
                median = getMedian(trailingDays);
                if (spend >= 2 * median) {
                    count++;
                }
                trailingDays.add(spend);
                trailingDays.remove(0);
            } else {
                trailingDays.add(spend);
            }
        }
        return count;
    }

    private static int getMedian(List<Integer> trailingDays) {
        Collections.sort(trailingDays);
        int maxIndex = trailingDays.size() - 1;
        if (trailingDays.size() % 2 == 1) {
            return trailingDays.get(maxIndex / 2);
        } else {
            return (trailingDays.get(trailingDays.size() / 2) + trailingDays.get(trailingDays.size() / 2 + 1)) / 2;
        }
    }

    public static void bad() {
    }

    public static void main(String[] args) {
        int[] e = new int[]{10, 20, 30, 40, 50};
        int d = 3;
        System.out.println(activityNotifications(e, d));
    }
}
