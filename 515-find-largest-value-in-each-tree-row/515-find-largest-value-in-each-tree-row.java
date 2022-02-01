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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null){
            return ls;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                max = Math.max(max,pop.val);
                if(pop.left!=null){
                    q.add(pop.left);
                }
                if(pop.right!=null){
                    q.add(pop.right);
                }
            }
                ls.add(max);
            
            
        }
        
        return ls;
    }
}