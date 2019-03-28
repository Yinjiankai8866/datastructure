package com.darrenchan.tree;

public class TreeNode {
    public String value;          //树结构中的值
    public TreeNode left;           //定义的树的左支树
    public TreeNode right;          //定义的树的右子树

    public TreeNode(String value) {    //构造方法用来给树的结点赋值
        this.value = value;
    }
}
