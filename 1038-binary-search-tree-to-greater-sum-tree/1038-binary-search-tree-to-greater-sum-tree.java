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
    public TreeNode bstToGst(TreeNode root) {
        if(root == null){
            return null;
        }
        sum = 0;
        fun(root);
        return root;
    }
    
    void fun(TreeNode root){
        if(root == null){
            return;
        }
        fun(root.right);
        root.val = root.val + sum;
        sum = root.val;
        fun(root.left);
    }
    
}