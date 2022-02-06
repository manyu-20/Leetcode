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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val == low){
            root.left = null;
            root.right = trimBST(root.right,low,high);
            return root;
        }
        else if(root.val == high){
            root.right = null;
            root.left = trimBST(root.left,low,high);
            return root;
        }
        TreeNode left = trimBST(root.left,low,high);
        TreeNode right = trimBST(root.right,low,high);
        if(root.val >low && root.val < high){
            root.left = left;
            root.right = right;
            return root;
        }
        if(right == null){
            return left;
        }
        if(left == null){
            return right;
        }
        right.left = left;
        return right;
        
    }
}