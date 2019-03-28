package com.darrenchan.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Traverse {
    /**
     * 非递归实现前序遍历（前序遍历首先访问根结点然后遍历左子树，最后遍历右子树。）
     * 就是先把根节点压栈，然后根节点出栈，再依次把右节点，左节点压栈，然后相继出栈
     */
    public static void preOrder(TreeNode head){
        if(head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);   //把根节点放到stack栈中
            while(!stack.isEmpty()){
                TreeNode pop = stack.pop();   //stack.peek()取栈顶值（不出栈）stack.pop();出栈
                System.out.print(pop.value + " ");
                if(pop.right != null){
                    stack.push(pop.right);
                }
                if(pop.left != null){
                    stack.push(pop.left);
                }
            }
        }
    }

    /**
     * 非递归实现中序遍历（中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树）
     */
    public static void inOrder(TreeNode head){
        if(head != null){
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){  //head节点不是空的
                if(head != null){   //head节点不是空的
                    stack.push(head); //把head节点压入栈中
                    head = head.left; //head节点指向左支树
                }else{              //head节点是空的，并且栈不是空的
                    head = stack.pop();  //压入栈的左支树开始出栈，head出栈，
                    System.out.print(head.value + " ");
                    head = head.right;//出栈完成以后，head的右支树开始压栈，压栈完后，再压这个右支树的左支树，依次类推
                }
            }
        }
    }

    /**
     * 非递归实现后序遍历（，先左后右再根，即首先遍历左子树，然后遍历右子树，最后访问根结点。）
     */
    public static void postOrder(TreeNode head){
        if(head != null){
            Stack<TreeNode> stack1 = new Stack<>(); //第一个栈
            Stack<TreeNode> stack2 = new Stack<>(); //第二个栈
            stack1.push(head); //把head节点push到stack1中
            while(!stack1.isEmpty()){
                TreeNode pop = stack1.pop();//stack1出栈
                stack2.push(pop);//stack2入栈
                if(pop.left != null){ //pop的左支树不为空的话
                    stack1.push(pop.left);//pop的左支树入栈stack1
                }
                if(pop.right != null){ //pop的右支树不为空的话
                    stack1.push(pop.right); //pop.right入栈stack1
                }
                //stack2中入栈的分别是，head，headd的左支树，head的右支树，以此类推
            }
            //当stack1出栈完毕以后，stack2也入栈完毕，此时，stack2开始出栈
            while(!stack2.isEmpty()){
                System.out.print(stack2.pop().value + " "); //此时便是后序遍历的序列
            }
        }
    }

    /**
     * 层次遍历
     */
    //add()和offer()     poll()和remove()          element() 和 peek()
    public static void levelOrder(TreeNode head){
        if(head != null){           //如果head不是空
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(head);      //head入队
            while(!queue.isEmpty()){ //
                //获取当前层的节点数
                int levelNum = queue.size(); //队列的长度
                for (int i = 0; i < levelNum; i++) {
                    TreeNode poll = queue.poll();
                    System.out.print(poll.value + " "); //poll出队

                    if(poll.left != null){          //poll出队以后，poll的左支树入队
                        queue.offer(poll.left);         //如果当前节点的左支树不为空，入队
                    }

                    if(poll.right != null){           //然后右支树入队
                        queue.offer(poll.right);    //然后参与循环，直到一层的元素出队完毕，
                    }                                   //当前节点的右支树不为空入队
                                                        //然后右边的节点一次类推，一层上的元素就相继入队，出队的顺序也是一样的，就实现了层次遍历
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = H;
        D.right = I;
        E.right = J;
        C.left = F;
        C.right = G;
        F.right = K;

        preOrder(A);
        System.out.println();
        inOrder(A);
        System.out.println();
        postOrder(A);
        System.out.println();
        levelOrder(A);
    }
}
