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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return fun(nums,0,nums.length-1);
    }
    
    private TreeNode fun(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        int[] res = give(nums,start,end);
        int max = res[0];
        int index = res[1];
        TreeNode root = new TreeNode(max);
        root.left = fun(nums,start,index-1);
        root.right = fun(nums,index+1,end);
        return root;
    }
    
    private int[] give(int[] nums,int start,int end){
        int max = -1;
        int index = -1;
        for(int i = start;i<=end;i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        
        return new int[]{max,index};
    }
}