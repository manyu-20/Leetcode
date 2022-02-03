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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return fun(root,0,targetSum);
    }
    
    private boolean fun(TreeNode root,int sum,int target){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val + sum == target;
        }
        int total = root.val + sum;
       
        return fun(root.left,total,target) || fun(root.right,total,target);
        
    }
}