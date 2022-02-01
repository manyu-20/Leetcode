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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode temp = root;
        if(root == null){
            return null;
        }
        if(depth == 1){
            temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        fun(temp,val,depth,1);
        return root;
    }
    
    private void fun(TreeNode root,int val, int depth,int count){
        if(root == null || count > depth + 1){
            return;
        }
        if(count == depth-1){
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode nLeft = new TreeNode(val);
            TreeNode nRight = new TreeNode(val);
            root.left = nLeft;
            nLeft.left = left;
            root.right = nRight;
            nRight.right = right;
            return ;
        }
        fun(root.left,val,depth,count+1);
        fun(root.right,val,depth,count+1);

    }
    

}