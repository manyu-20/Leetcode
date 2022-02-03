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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        int data = root.val;
        return fun(root,data);
    }
    
    private boolean fun(TreeNode root,int data){
        if(root == null){
            return true;
        }
        if(data != root.val){
            return false;
        }
        
        return fun(root.left,data) && fun(root.right,data);
    }
}