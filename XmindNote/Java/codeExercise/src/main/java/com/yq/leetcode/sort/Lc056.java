package com.yq.leetcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author admin
 */
public class Lc056 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> resultList = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) ->
                o1[0] > o2[0] ? 1 : o1[0] == o2[0] ? 0 : -1);
        int startNum = intervals[0][0];
        int endNum = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > endNum) {
                resultList.add(new int[]{startNum, endNum});
                startNum = intervals[i][0];
                endNum = intervals[i][1];
            } else if (intervals[i][1] > endNum) {
                endNum = intervals[i][1];
            }
        }
        resultList.add(new int[]{startNum, endNum});
        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

}
