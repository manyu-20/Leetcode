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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        fun(root,arr);
        if(k-1 >= arr.size()){
            return -1;
        }
        return arr.get(k-1);
    }
    
    void fun(TreeNode root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        fun(root.left,arr);
        arr.add(root.val);
        fun(root.right,arr);
    }
}