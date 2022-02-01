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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            double ans = 0;
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                ans = ans + pop.val;
                if(pop.left != null){
                    q.add(pop.left);
                }
                if(pop.right!=null){
                    q.add(pop.right);
                }
            }
            ans = ans/n;
            res.add(ans);
        }
        
        return res;
    }
}