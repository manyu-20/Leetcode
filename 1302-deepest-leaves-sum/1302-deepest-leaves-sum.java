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
    int sum;
    public int deepestLeavesSum(TreeNode root) {
        sum = 0;
        if(root == null){
            return sum;
        }
        int h = depth(root);
        fun(root,h,1);
        return sum;
        
    }
    
    void fun(TreeNode root,int h,int count){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null && count == h){
            sum = sum + root.val;
            return;
        }
        fun(root.left,h,count+1);
        fun(root.right,h,count+1);
    }
    
    int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(depth(root.left),depth(root.right));
    }
}