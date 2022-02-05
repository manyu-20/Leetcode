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
    static List<TreeNode> list;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        list = new ArrayList<>();
        if(root == null || to_delete.length  == 0){
            return list;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int x : to_delete){
            hs.add(x);
        }
        dfs(root,hs);
        fun(root);
        if(root.val != -1){
            list.add(root);
        }
        return list;
    }
    
    void fun(TreeNode root){
        if(root == null){
            return;
        }
        fun(root.left);
        fun(root.right);
        
        if(root.left != null && root.left.val == -1){
            root.left = null;
        }
        if(root.right != null && root.right.val == -1){
            root.right = null;
        }
        
        if(root.val == -1){
            TreeNode leftChild = root.left;
            root.left = null;
            TreeNode rightChild = root.right;
            root.right = null;
            if(leftChild != null){
                list.add(leftChild);
            }
            if(rightChild != null){
                list.add(rightChild);
            }
        }
        
        
    }
    
    void dfs(TreeNode root,HashSet<Integer> hs){
        if(root == null){
            return;
        }
        if(hs.contains(root.val)){
            root.val = -1;
        }
        dfs(root.left,hs);
        dfs(root.right,hs);
    }
}