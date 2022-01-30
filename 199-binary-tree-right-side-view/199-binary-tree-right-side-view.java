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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode temp = root;
        q.add(temp);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                map.put(level,pop.val);
                if(pop.left!= null){
                    q.add(pop.left);
                }
                if(pop.right!=null){
                    q.add(pop.right);
                }
            }
            level++;
        }
        
        for(int x : map.keySet()){
            list.add(map.get(x));
        }
        return list;
    }
}