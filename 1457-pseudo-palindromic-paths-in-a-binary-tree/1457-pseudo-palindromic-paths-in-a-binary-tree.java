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
    public int pseudoPalindromicPaths (TreeNode root) {
        res = 0;
        if(root == null){
            return 0;
        }
        fun(root,new HashSet<>());
        return res;
    }
    
    void fun(TreeNode root,HashSet<Integer> hs) {
        if(root == null){
            return;
        }
        if(hs.contains(root.val)){
            hs.remove(root.val);
        }
        else{
            hs.add(root.val);
        }
        if(root.left == null && root.right == null){
            if(hs.size() <= 1){
                res++;
            }
            return;
        }

        fun(root.left,new HashSet<>(hs));

        fun(root.right,new HashSet<>(hs));
        
    }
    
}