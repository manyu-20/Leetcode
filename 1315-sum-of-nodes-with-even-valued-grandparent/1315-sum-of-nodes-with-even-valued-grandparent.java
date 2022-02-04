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
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null){
            return 0;
        }
        res = 0;
        fun(root);
        return res;
    }
    
    void fun(TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.val % 2 == 0){
            count(root,2);
        }
        
        fun(root.left);
        fun(root.right);
    }
    
    void count(TreeNode root,int dist){
        if(root == null){
            return;
        }
        if(dist == 0){
            res = res + root.val;
            return;
        }
        count(root.left,dist-1);
        count(root.right,dist - 1);
    }
}