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
    public boolean isValidBST(TreeNode root) {
        return fun(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean fun(TreeNode root,long start,long end){
        if(root == null){
            return true;
        }
        if(root.val <= start || root.val >= end){
            return false;
        }
        return fun(root.left,start,root.val) && fun(root.right,root.val,end);
    }
}