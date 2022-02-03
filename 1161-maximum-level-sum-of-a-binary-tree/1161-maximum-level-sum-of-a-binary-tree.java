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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()){
            int n = q.size();
            int sum = 0;
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                sum = sum + pop.val;
                if(pop.left !=null){
                    q.add(pop.left);
                }
                if(pop.right!=null){
                    q.add(pop.right);
                }
            }
            if(max < sum){
                max = Math.max(max,sum);
                index = level;
            }
            level++;
        }
        
        return index;
        
        
    }
}