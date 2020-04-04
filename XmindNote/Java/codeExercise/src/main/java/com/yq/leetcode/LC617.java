package com.yq.leetcode;

import com.yq.associate.TreeNode;

public class LC617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        traceBack(t1, t2);
        return t1;
    }

    private void traceBack(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return;
        } else if (t1 == null && t2 != null) {
            t1 = t2;
            return;
        }
        t1.val += t2.val;
        traceBack(t1.left,t2.left);
        traceBack(t1.right,t2.right);
    }


}

