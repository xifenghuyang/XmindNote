package com.yq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC040 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int curIndex = 0;
        search(candidates, target, curIndex, path, pathList);
        return pathList;
    }

    private void search(int[] candidates, int target, int curIndex,
                        List<Integer> path, List<List<Integer>> pathList) {
        // 遍历结束
        if (target < 0) {
            return;
        } else if (target == 0) {
            pathList.add(new ArrayList<>(path));
            return;
        } else {
            for (int start = curIndex; start < candidates.length; start++) {
                if(start!=curIndex && candidates[start] == candidates[start-1]){
                    continue;
                }
                if (target < candidates[start]) {
                    return;
                }
                path.add(candidates[start]);
                search(candidates, target - candidates[start], start+1, path, pathList);
                path.remove(path.size() - 1);
            }
        }
    }

}
