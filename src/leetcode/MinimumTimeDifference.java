package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhaochaoqun on 2017/6/27.
 */
public class MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        String[] time;
        for(int i = 0; i < timePoints.size(); i++) {
            time = timePoints.get((i)).split(":");
            times[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        Arrays.sort(times);
        int min = 1440, diff = 0;
        for(int i = 1; i < times.length; i++) {
            diff = times[i] - times[i-1];
            if(diff < min)
                min = diff;
        }
        diff = 1440 + times[0] - times[times.length - 1];
        if(diff < min)
            min = diff;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMinDifference(Arrays.asList("23:59","00:00")));
    }
}
