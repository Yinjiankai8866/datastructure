package com.darrenchan.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Depth {
    /**
     * 递归最大深度
     * 使用递归，相当于遍历了整个二叉树，递归返回深度浅的那棵子树的深度。
     */
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        //也就是说左边的左支树一直加1，右边的右支树也一支加1，直到
        int left = maxDepth(root.left);   //左边的支树递归深度（这个方法会一直执行，直到返回left=0）
        int right = maxDepth(root.right);  //右支树递归深度（这个方法会一直执行，直到返回right=0）
        return Math.max(left, right) + 1; //凡是递归的节点都会调到这个方法，调一次加一次
    }
    /**
     * 非递归最大深度
     */
    public int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll(); //出队
                if(node.left != null){
                    queue.offer(node.left);  //左支树入队
                }
                if(node.right != null){      //右支树入队
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

    /**
     * 递归最小深度
     */
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null && root.right != null){
            return minDepth(root.right) + 1;
        }
        if(root.left != null && root.right == null){
            return minDepth(root.left) + 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }

    /**
     * 非递归最小深度
     */
    public int minDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();

                if(node.left == null && node.right == null){
                    return level;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return 0;
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

        Depth depth = new Depth();
        System.out.println(depth.maxDepth(A));
        System.out.println(depth.maxDepth2(A));
        System.out.println(depth.minDepth(A));
        System.out.println(depth.minDepth2(A));
    }

}
