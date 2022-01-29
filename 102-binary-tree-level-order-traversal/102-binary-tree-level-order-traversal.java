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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        res.add(new ArrayList<>(first));
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            ArrayList<Integer> arr = new ArrayList<>();
            int n = q.size();
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                if(pop.left != null){
                    q.add(pop.left);
                    arr.add(pop.left.val);
                }
                if(pop.right!=null){
                    q.add(pop.right);
                    arr.add(pop.right.val);
                }
            }
            if(arr.size() != 0){
            res.add(new ArrayList<>(arr));
            }
        }
        
        return res;
    }
}