package com.pickbucket.leetcode.easy;

import com.pickbucket.leetcode.common.TreeNode;

public class P_235_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootValue = root.val;
        int leftValue = p.val;
        int rightValue = q.val;

        if (leftValue > rootValue && rightValue > rootValue) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (leftValue < rootValue && leftValue < rootValue) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }


}
