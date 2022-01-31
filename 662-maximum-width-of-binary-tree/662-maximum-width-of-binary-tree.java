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
    static class pair{
        int num;
        TreeNode node;
        pair(int _num,TreeNode _node){
            num = _num;
            node = _node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = 1;
        
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,root));
        
        while(!q.isEmpty()){
            int n = q.size();
            int start = 0;
            int end = 0;
            int min = q.peek().num;
            for(int i = 0;i<n;i++){
                TreeNode pop = q.peek().node;
                int num = q.peek().num;
                q.remove();
                if(i == 0)start = num - min;
                if(i == n-1) end = num - min;
                if(pop.left!=null){
                    q.add(new pair(2 * (num - min) + 1,pop.left));
                }
                if(pop.right!=null){
                    q.add(new pair(2 * (num - min) + 2,pop.right));
                }

            }
            
            max = Math.max(max,end - start+1);
        }
        
        return max;
    }
}