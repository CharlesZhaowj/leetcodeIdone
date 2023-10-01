package com.pickbucket.leetcode.simulate.binarytree;

import com.pickbucket.leetcode.common.TreeNode;

public class P_560_diameterOfBinaryTree {

    int ans;

    /**
     * 直径不一定要经过根节点，所以利用计算深度的时候顺便算出来...
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        getDepth(root);
        return ans - 1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        ans = Math.max(ans, l+r+1); // 直径
        return Math.max(l, r) + 1; // 深度要算上结点本身的
    }
}
