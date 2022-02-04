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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = root.val;
        res = 0;
        fun(root,max);
        return res;
    }
    
    void fun(TreeNode root,int max){
        if(root == null){
            return;
        }
        if(max <= root.val){
            max = root.val;
            res++;
        }

        
        fun(root.left,max);
        fun(root.right,max);
    }
}