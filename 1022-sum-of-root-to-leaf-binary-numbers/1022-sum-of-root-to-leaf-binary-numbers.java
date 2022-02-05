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
    int sum;
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        fun(root,arr);
        return sum;
    }
    
    
    private void fun(TreeNode root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        arr.add(root.val);
        if(root.left == null && root.right == null){
            sum = sum + toNum(arr);
            return;
        }  
        fun(root.left,new ArrayList<>(arr));
        fun(root.right,new ArrayList<>(arr));
    }
    
    private int toNum(ArrayList<Integer> arr){
        int res = 0;
        int start = 1;
        for(int i = arr.size()-1;i>=0;i--){
            int x = arr.get(i);
            res += start * x;
            start *= 2;
        }
        return res;
    }
}