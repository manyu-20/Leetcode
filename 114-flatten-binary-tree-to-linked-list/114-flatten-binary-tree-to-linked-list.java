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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        fun(root);
        
    }
    
    private TreeNode fun(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode right = fun(root.right);
        root.right = null;
        TreeNode left = fun(root.left);
        root.left = null;
        root.right = left;
        TreeNode curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = right;
        
        return root;
    }
}