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
    static List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new ArrayList<>();
        if(root == null){
            return list;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        fun(root,targetSum,arr);
        return list;
    }
    
    private void fun(TreeNode root,int targetSum,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        if(root != null && root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                arr.add(root.val);
                list.add(new ArrayList<>(arr));
                arr.remove(arr.size()-1);
                return;
            }
            else{
                return;
            }
        }
        arr.add(root.val);
        fun(root.left,targetSum-root.val,arr);
        fun(root.right,targetSum-root.val,arr);
        arr.remove(arr.size()-1);
    }
}