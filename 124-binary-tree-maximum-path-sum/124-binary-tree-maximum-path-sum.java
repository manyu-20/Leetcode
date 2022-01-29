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
    int max;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        max = -99999;
        fun(root);
        return max;
    }
    
    private int fun(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = fun(root.left);
        if(left < 0)left = 0;
        int right = fun(root.right);
        if(right < 0)right = 0;
        int val = root.val;
        
        max = Math.max(max,left + right + val);
        int give = Math.max(left,right);
        
        return val + give;
    }
}