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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        int height = depth(root) - 1;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int start = 0;
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                if(start < height - 1){
                    if(pop.left==null || pop.right == null){
                        return false;
                    }
                    q.add(pop.left);
                    q.add(pop.right);
                }
                else{
                    if(pop.left!=null){
                        arr.add(pop.left.val);
                    }
                    else{
                        arr.add(-1);
                    }
                    if(pop.right!=null){
                        arr.add(pop.right.val);
                    }
                    else{
                        arr.add(-1);
                    }
                }
            }
            
            if(arr.size() != 0){
                while(arr.size() > 0 && arr.get(arr.size()-1) == -1){
                    arr.remove(arr.size()-1);
                }
                for(int x : arr){
                    if(x == -1){
                        return false;
                    }
                }
            }
            start++;
        }
        return true;
    }
    
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(depth(root.left),depth(root.right));
    }
}