package com.darrenchan.stack;

import com.darrenchan.list.ListNode;

public class MyStack {
    public ListNode statckTop;
    public ListNode statckBottom;

    public MyStack(ListNode statckTop, ListNode statckBottom) {
        this.statckTop = statckTop;
        this.statckBottom = statckBottom;
    }

    /**
     * 进栈
     */
    public static void pushStack(MyStack myStack, int value){
        ListNode node = new ListNode(value);
        node.next = myStack.statckTop;
        myStack.statckTop = node;
    }
    /**
     * 遍历
     * 栈顶元素指针不指向栈底
     */
    public static void traverse(MyStack myStack){
        ListNode stackTop = myStack.statckTop;
        while(stackTop != myStack.statckBottom){
            System.out.print(stackTop.value + " ");
            stackTop = stackTop.next;
        }
        System.out.println();
    }

    /**
     * 判断栈是否为空
     */
    public static boolean isEmpty(MyStack myStack){
        if(myStack.statckTop == myStack.statckBottom){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 出栈
     */
    public static void popStack(MyStack myStack){
        //栈不为空才出栈
        if(!isEmpty(myStack)){
            ListNode stackTop = myStack.statckTop;
            myStack.statckTop = stackTop.next;
            System.out.println(stackTop.value);
        }
    }

    /**
     * 清空栈
     */
    public static void clearStack(MyStack myStack){
        myStack.statckTop = null;
        myStack.statckBottom = myStack.statckTop;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(new ListNode(0), new ListNode(0));
        myStack.statckBottom = myStack.statckTop;

        System.out.println(isEmpty(myStack));
        pushStack(myStack, 1);
        pushStack(myStack, 2);
        pushStack(myStack, 3);
        traverse(myStack);
        System.out.println(isEmpty(myStack));

        popStack(myStack);
        clearStack(myStack);

        System.out.println(isEmpty(myStack));
    }
}
