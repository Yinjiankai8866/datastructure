package com.darrenchan.queue;

import java.util.Stack;

public class TwoStackOneQueue {
    public static Stack<Integer> stackPush;
    public static Stack<Integer> stackPop;

    public TwoStackOneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void add(int value){
        stackPush.push(value);
    }

    /**
     * 出队
     * @return
     */
    public int poll(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /**
     * 获取队首元素
     * @return
     */
    public int peek(){
        if(stackPop.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackOneQueue queue = new TwoStackOneQueue(new Stack<Integer>(), new Stack<Integer>());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }
}
