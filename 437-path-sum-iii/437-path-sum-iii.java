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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        return sum(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
    
    private int sum(TreeNode root,int target){
        int res = 0;
        if(root == null){
            return res;
        }
        if(target == root.val){
            res++;
        }
        res = res + sum(root.left,target-root.val) + sum(root.right,target-root.val);
        return res;
    }
}