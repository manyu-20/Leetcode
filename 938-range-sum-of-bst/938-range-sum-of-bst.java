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
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        if(root == null){
            return 0;
        }
        fun(root,low,high);
        return sum;
    }
    
    void fun(TreeNode root,int low,int high){
        if(root == null){
            return;
        }
        if(root.val <= high && root.val >= low){
            sum = sum + root.val;
        }
        fun(root.left,low,high);
        fun(root.right,low,high);
    }
    
    
}