package com.yq.everyday;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  每日一题：单调递减双端队列
 *  保证每个元素的前面都没有比它小的元素。
 */
public class LC0307 {
    // 双端队列，头尾操作
    Deque<Integer> maxQue;
    Queue<Integer> queue;

    public LC0307() {
        maxQue = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQue.isEmpty()) {
            return -1;
        } else {
            return maxQue.peekFirst();
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        // 出队条件
        while (!maxQue.isEmpty() && value > maxQue.peekLast()) {
            maxQue.pollLast();
        }
        // 入队条件
        if (maxQue.isEmpty() || value <= maxQue.peekLast()) {
            maxQue.offer(value);
        }

    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        if (queue.peek().compareTo(maxQue.peekFirst()) == 0) {
            maxQue.pollFirst();
        }
        return queue.poll();
    }

}
