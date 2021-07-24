package com.pickbucket.leetcode.middle;

import com.pickbucket.leetcode.common.TreeNode;

public class P_814_pruneTree {

    // 递归
    public static TreeNode pruneTreeVerII(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public static boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1) node.left = null;
        if (!a2) node.right = null;
        return node.val == 1 || a1 || a2;
    }

    // 后序遍历
    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.right = pruneTree(root.right);
        root.left = pruneTree(root.left);
        if (root.left == null && root.right == null && root.val != 1) {
            return null;
        }
        return root;
    }
}
