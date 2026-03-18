/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // first Condition : if root is equal to p or q return 
        if(root == null || root == p || root == q) return root;

        if(root.left == null && root.right == null) return null;

        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);

        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return root;
        }
    }
}