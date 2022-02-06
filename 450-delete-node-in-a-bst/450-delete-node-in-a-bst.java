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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            TreeNode left = root.left;
            TreeNode right = root.right;
            return merge(left,right);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
    
    TreeNode merge(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return null;
        }
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(right.val < left.val){
            left.left = merge(left.left,right);
        }
        else{
            left.right = merge(left.right,right);
        }
        return left;
    }
}