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

    int min;
    int prev;
    public int getMinimumDifference(TreeNode root) {
        prev = -1;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }
    
    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev == -1){
            prev = root.val;
        }
        else{
            min = Math.min(min,Math.abs(prev - root.val));
            prev = root.val;
        }
        inorder(root.right);
    }
}