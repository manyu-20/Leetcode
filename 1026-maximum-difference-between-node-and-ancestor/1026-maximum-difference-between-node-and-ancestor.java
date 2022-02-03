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
    int res;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = -1;
        int min = Integer.MAX_VALUE;
        res = 0;
        fun(root,max,min);
        return res;
    }
    
    private void fun(TreeNode root,int max,int min){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            max = Math.max(max,root.val);
            min = Math.min(min,root.val);
            res = Math.max(res,Math.abs(max - min));
            return;
        }
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        fun(root.left,max,min);
        fun(root.right,max,min);
    }
}