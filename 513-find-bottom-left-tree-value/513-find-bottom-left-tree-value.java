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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return -1;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode temp = root;
        q.add(temp);
        int level = 0;
        int res = -1;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                res = pop.val;
                if(pop.right!= null){
                    q.add(pop.right);
                }
                if(pop.left!=null){
                    q.add(pop.left);
                }
            }
            level++;
        }
        
        return res;
        
    }
}