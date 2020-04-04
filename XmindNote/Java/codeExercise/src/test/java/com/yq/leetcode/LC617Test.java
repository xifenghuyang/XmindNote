package com.yq.leetcode;

import com.yq.associate.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC617Test {

    @Test
    public void mergeTrees() {

        int[] leftTree= {1,3,2,5};
        int[] rightTree={2,1,3,-1,4,-1,7};


        TreeNode LT = new TreeNode(1);
        LT.left = new TreeNode(3);
        LT.right = new TreeNode(2);
        LT.left.left = new TreeNode(5);

        TreeNode RT = new TreeNode(2);
        RT.left = new TreeNode(1);
        RT.right = new TreeNode(3);
        RT.left.right = new TreeNode(4);
        RT.right.right = new TreeNode(7);

        LC617 lc617 = new LC617();
        lc617.mergeTrees(LT,RT);


    }
}