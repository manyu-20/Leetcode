/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return null;
        }
        ArrayList<TreeNode> pList = new ArrayList<>();
        ArrayList<TreeNode> qList = new ArrayList<>();
        TreeNode temp = root;
        dfs(temp,p,pList);
        temp = root;
        dfs(temp,q,qList);
        int start = Math.min(pList.size(),qList.size()) - 1;

        for(int i = start ; i >= 0 ; i--){
            if(pList.get(i).val == qList.get(i).val){
                return qList.get(i);
            }            
        }
        
        return temp;
    }
    
    private boolean dfs(TreeNode root,TreeNode target,ArrayList<TreeNode> arr){
        if(root == null){
            return false;
        }
        arr.add(root);
        if(root.val == target.val){
            return true;
        }
        
        if(dfs(root.left,target,arr) || dfs(root.right,target,arr)){
            return true;
        }
        
        arr.remove(arr.size()-1);
        
        return false;
    }
}