package LeetCode.LC225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> Q1=new LinkedList<>();
    Queue<Integer> Q2=new LinkedList<>();
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        while (!Q2.isEmpty()){
            Q1.add(Q2.poll());
        }
        Q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(Q1.size()>1){
            Q2.add(Q1.poll());
        }
        return Q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return Q1.isEmpty() && Q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */