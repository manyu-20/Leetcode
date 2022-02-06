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
    TreeNode first,mid,sec,prev;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        first = mid = sec = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(sec == null){
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
        else{
            int temp = first.val;
            first.val = sec.val;
            sec.val = temp;
        }
    }
    
    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        
        if((prev != null) && prev.val > root.val){
            if(first == null){
                first = prev;
                mid = root;
            }
            else{
                sec = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}