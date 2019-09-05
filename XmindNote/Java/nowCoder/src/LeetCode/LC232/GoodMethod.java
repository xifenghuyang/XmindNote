package LeetCode.LC232;

import java.util.Stack;

/**
 * 使用了front变量，避免压入、弹出操作。
 */

public class GoodMethod {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;

    // Push element x to the back of queue.
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    public void pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        s2.pop();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Get the front element.
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }


}
