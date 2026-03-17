/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static int maxSum;
    public int solve(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0,solve(root.left));
        int right = Math.max(0,solve(root.right));

        // if left + right + root is maximum then we don't need to go upward just return from here 
        int possibleBest = left + right + root.val;

        maxSum = Math.max(possibleBest, maxSum);

        // best any one of them left or right + root

        return root.val + Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}