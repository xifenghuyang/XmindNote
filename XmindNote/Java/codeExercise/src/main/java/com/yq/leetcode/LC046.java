package com.yq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC046 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            visited[i]=false;
        }
        search(nums, visited, path, pathList);
        return pathList;
    }

    private void search(int[] nums, boolean[] visited, List<Integer> path,
                        List<List<Integer>> pathList) {

       if (isAllVisited(visited)) {
            pathList.add(new ArrayList<>(path));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(visited[i]){
                    continue;
                }
                visited[i] = true;
                path.add(nums[i]);
                search(nums, visited, path, pathList);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }

    private boolean isAllVisited(boolean[] visited){
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }


}
