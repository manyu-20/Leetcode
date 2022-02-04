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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null){
            return root;
        }
        int ans = fun(root,target);
        if(ans == 0 && root != null && root.val == target){
            return null;
        }
        return root;
        
    }
    // target   =  0
    //root is null = -1
    int fun(TreeNode root,int target){
        if(root == null){
            return -1;
        }
        if(root.left == null && root.right == null && root.val == target){
            return 0;
        }
        if(root.left == null && root.right == null){
            return -2;
        }
        
        int left = fun(root.left,target);
        if(left == 0)root.left = null;
        int right = fun(root.right,target);
        if(right == 0)root.right = null;
        
        if( ((left == 0 && right == -1) || (left == -1 && right == 0) || (left == 0 && right == 0)) && root.val == target){
            return 0;
        }
        
        return -2;
        
        
    }
}