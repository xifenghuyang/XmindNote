package com.yq.leetcode.dfs;

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

import javax.imageio.metadata.IIOInvalidTreeException;
import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author admin
 */
public class LC105 {

//     Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {

        /**
         * 前序遍历知道根
         * 中序遍历知道分隔点
         * @param preorder
         * @param inorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int len = preorder.length;
            if(len <= 0){
                return null;
            }
            // 存储元素对应关系
            // 顺序找根--用队列
            // 哈希找索引——用map
            Queue<Integer> preQueue = new LinkedList<>();
            Map<Integer, Integer> inMap = new HashMap<>(len);
            for (int i = 0; i < len ; i++) {
                preQueue.add(preorder[i]);
                inMap.put(inorder[i], i);
            }

            int root = preQueue.poll();
            int rootIndex = inMap.get(root);
            TreeNode tree = new TreeNode(root);
            tree.left = buildTreeHelp(preQueue, inMap, 0, rootIndex - 1);
            tree.right = buildTreeHelp(preQueue, inMap, rootIndex + 1, len - 1);
            return tree;
        }

        public TreeNode buildTreeHelp(Queue<Integer> preQueue, Map<Integer, Integer> inMap, int i, int j){
            if(i > j || preQueue.isEmpty()){
                return null;
            }
            int root = preQueue.poll();
            int rootIndex = inMap.get(root);
            TreeNode tree = new TreeNode(root);
            tree.left = buildTreeHelp(preQueue, inMap, i, rootIndex-1);
            tree.right = buildTreeHelp(preQueue, inMap, rootIndex+1,j);
            return tree;
        }
    }

}
