package com.darrenchan.tree;

/**
 * 实战之查找两个节点的最近公共祖先
 */
public class LowestAncestor {
    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     * 1, 如果发现cur等于null, 或者o1, o2。则返回cur.
     * 2,如果left和right都为空，说明cur整棵子树都没有发现过o1 和o2,返回null.
     * 3.如果left和right都不为空，说明左子树上发现过o1 和 o2，右子树上也发现过o1 和o2，说明o1 向上与o2向上的过程中，首次在cur相遇，返回cur.
     * 4,如果left和right是有一个为空，另一个不为空，假设不为空的那个记为node，此时又两种肯，要么node是o1或o2中的一个，要么node已经是o1和o2的最近公共祖先节点，此时直接返回node即可。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
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

        LowestAncestor lowestAncestor = new LowestAncestor();
        TreeNode treeNode = lowestAncestor.lowestCommonAncestor(A, B, F);
        System.out.println(treeNode.value);
    }
}
