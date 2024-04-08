package com.shubham.goyal.coding;

import java.util.HashMap;
import java.util.Map;


/***
 * Given a binary tree with a value associated with each node,
 * we need to choose a subset of these nodes such that the sum of selected nodes is maximum under a constraint
 * that no two chosen nodes in the subset should be directly connected, that is, if we have taken a node in our sum
 * then we can’t take any of its children in consideration and vice versa
 * https://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
 */
public class MaxTreeSumNoAdjacentNode {


    private static int getGrandChildrenSum(TreeNode root, Map<TreeNode, Integer> cacheMap){

        int ans = 0;

        if(root.left != null){
            ans = ans + maxSum(root.left.left, cacheMap) + maxSum(root.left.right, cacheMap);
        }

        if(root.right != null){
            ans = ans + maxSum(root.right.left, cacheMap) +  maxSum(root.right.right, cacheMap);;
        }

        return ans;

    }

    private static int maxSum(TreeNode root, Map<TreeNode, Integer> cacheMap){

        if(root == null){
            return 0;
        }

        if(cacheMap.containsKey(root)){
            return cacheMap.get(root);
        }

        int withRoot = root.data + getGrandChildrenSum(root, cacheMap);

        int withoutRoot = maxSum(root.left, cacheMap) + maxSum(root.right, cacheMap);

        int rootSum = Math.max(withRoot, withoutRoot);

        cacheMap.put(root, rootSum);

        return rootSum;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        Map<TreeNode, Integer> node = new HashMap<>();
        System.out.print(maxSum(root, node));

    }

}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
