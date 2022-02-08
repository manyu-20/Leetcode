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
    HashMap<TreeNode,Integer> hm;
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        hm = new HashMap<>();
        return fun(root);
        
    }
    
    int fun(TreeNode root){
        if(root == null){
            return 0;
        }
        
        if(hm.containsKey(root)){
            return hm.get(root);
        }
        
        int sum = root.val;
        
        if(root.left != null){
            sum = sum + fun(root.left.left) + fun(root.left.right);
        }
        if(root.right != null){
            sum = sum + fun(root.right.left) + fun(root.right.right);
        }
        
        int leaveIt = fun(root.left) + fun(root.right);
        
        hm.put(root,Math.max(sum,leaveIt));
        return hm.get(root);
        
        
    }
}