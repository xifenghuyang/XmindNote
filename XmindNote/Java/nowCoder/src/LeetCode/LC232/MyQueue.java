package LeetCode.LC232;

import java.util.Stack;

class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!popStack.empty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int result = this.pop();
        popStack.push(result);
        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
//        if(pushStack.empty() && popStack.empty()){
//            return true;
//        }else {
//            return false;
//        }
        return pushStack.empty() && popStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
