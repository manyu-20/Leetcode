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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> ll = new LinkedList<>();
        boolean leftToRight = true;
        ll.add(root);
        while(!ll.isEmpty()){
            int size = ll.size();
            int[] arr = new int[size];
            for(int i = 0;i<size;i++){
                TreeNode pop = ll.remove();
                if(leftToRight){
                    
                    arr[i] = pop.val;
                }
                else{
                   arr[arr.length - i - 1] = pop.val;
                }
                if(pop.left!=null){
                    ll.add(pop.left);
                }
                if(pop.right!=null){
                    ll.add(pop.right);
                }
            }
            
            if(leftToRight) leftToRight = false;
            else leftToRight = true;
            
            if(arr.length > 0){
                List<Integer> temp = new ArrayList<>();
                for(int i = 0;i<arr.length;i++){
                    temp.add(arr[i]);
                }
                res.add(temp);
            }
        }
        
        return res;
    }
}