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
    public TreeNode pruneTree(TreeNode root) {
        fun(root);
        if(root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
    
    boolean fun(TreeNode root){
        if(root == null){
            return false;
        }
        
        boolean left = fun(root.left);
        boolean right = fun(root.right);
        
        if(!left){
            root.left = null;
        }
        if(!right){
            root.right = null;
        }
        
        if(root.val == 0){
            return left || right || false;
        }
        else{
            return true;   
        }
    }
}