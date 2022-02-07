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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null);
        List<Integer> ls = new ArrayList<>();
        inorder(root,ls);
        TreeNode temp = root;
        int size = ls.size();
        for(int i = 0;i<size;i++){
            int x = ls.get(i);
            temp.val = x;
            if(temp.left != null){
                temp.left = null;
            }
            if(temp.right == null && i < size - 1){
                temp.right = new TreeNode(-1);
            }
            temp = temp.right;
        }
        return root;
    }
    
    void inorder(TreeNode root,List<Integer> ls){
        if(root == null){
            return;
        }
        inorder(root.left,ls);
        ls.add(root.val);
        inorder(root.right,ls);
    }
}