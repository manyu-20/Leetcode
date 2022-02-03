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
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            int max = Integer.MAX_VALUE;
            if(level % 2 == 0){
                max = -1;
            }
            
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                if(level % 2 == 0){
                    if(pop.val % 2 == 0 || max >= pop.val){
                        return false;
                    }
                    max = Math.max(max,pop.val);
                }
                else{
                    if(pop.val % 2 == 1 || max <= pop.val){
                        return false;
                    }
                    max = Math.min(max,pop.val);
                }
                if(pop.left != null){
                    q.add(pop.left);
                }
                if(pop.right != null){
                    q.add(pop.right);
                }
            }
            level++;
        }
        
        return true;
        
    }
}