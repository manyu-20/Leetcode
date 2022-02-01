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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<List<Integer>> st = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            ArrayList<Integer> arr = new ArrayList<>();
            int n = q.size();
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                arr.add(pop.val);
                if(pop.left != null){
                    q.add(pop.left);
                   
                }
                if(pop.right!=null){
                    q.add(pop.right);
                }
            }
            if(arr.size() != 0){
                System.out.println(arr);
                st.push(new ArrayList<>(arr));
            }
        }
        
        while(!st.isEmpty()){
            res.add(new ArrayList<>(st.pop()));
        }
        
        return res;
    }
}