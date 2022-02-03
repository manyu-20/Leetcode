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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        boolean res = false;
        if(root.val == subRoot.val){
            res = fun(root,subRoot);
        }
        
        return res || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    
    private boolean fun(TreeNode root,TreeNode sub){
        if(root == null && sub == null){
            return true;
        }
        if(root == null || sub == null){
            return false;
        }
        if(root.val != sub.val){
            return false;
        }
        return fun(root.left,sub.left) && fun(root.right,sub.right);
    }
    
}