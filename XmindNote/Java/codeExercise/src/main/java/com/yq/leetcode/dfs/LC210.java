package com.yq.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author admin
 */
public class LC210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 拓扑排序，图是树的遍历
        // 用map存储图的关系结构
        HashMap<Integer, List<Integer>> graph = new HashMap<>(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
//            List<Integer> temp = graph.getOrDefault(start, new ArrayList<>());
//            temp.add(end);
//            graph.put(start, temp);
            graph.computeIfAbsent(start,k->new ArrayList<>()).add(end);
        }

        // 遍历map图，需要记录访问过的元素，需要一个栈，记录路径
        Stack<Integer> path = new Stack<>();
        // 记录元素访问状态。需要一个数组
        int[] flag = new int[numCourses];  // 未访问过0，已访问未处理1，已访问并处理-1
        // 深度优先遍历
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, flag, path)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!path.isEmpty()) {
            result[index] = path.pop();
            index++;
        }
        return result;
    }

    // boolean true，路径执行成功，false，路径执行失败
    public boolean dfs(int i, HashMap<Integer, List<Integer>> graph, int[] flag, Stack<Integer> stack) {
        // 该元素已 访问未处理，有环
        if (flag[i] == 1) return false;
        // 该元素已 访问并处理过，
        if (flag[i] == -1) return true;
        flag[i] = 1; // 待处理
        if(graph.containsKey(i)){
            for (Integer node : graph.get(i)) {
                if (!dfs(node, graph, flag, stack)) {
                    return false;
                }
            }
        }
        flag[i] = -1;
        stack.push(i);
        return true;
    }

    public static void main(String[] args){
        LC210 lc210 = new LC210();
        int[][] inputs = new int[][]{
                {1,0}
        };
        lc210.findOrder(2,inputs);
    }

}
