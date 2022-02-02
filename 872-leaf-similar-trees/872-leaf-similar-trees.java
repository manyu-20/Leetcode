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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        fun(root1,first);
        fun(root2,second);
        if(first.size() != second.size()){
            return false;
        }
        for(int i = 0;i<first.size();i++){
            if(first.get(i) != second.get(i)){
                return false;
            }
        }
        return true;
    }
    
    private void fun(TreeNode root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            arr.add(root.val);
        }
        
        fun(root.left,arr);
        fun(root.right,arr);
    }
}