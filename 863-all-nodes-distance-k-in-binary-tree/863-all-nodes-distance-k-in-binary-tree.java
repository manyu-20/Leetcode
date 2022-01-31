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
    int max;
     List<Integer> list;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        list = new ArrayList<>();
        if(root == null || target == null){
            return list;
        }
        TreeNode temp = root;
        max = 1;
        num(temp);
        for(int i = 0;i<=max;i++){
            arr.add(new ArrayList<>());
        }
        temp = root;
        dfs(temp,arr);
        temp = root;
        helper(target.val,-1,k,arr);
        return list;
    }
    
    private void helper(int target,int parent,int k,ArrayList<ArrayList<Integer>> arr){
        if(k == 0){
            list.add(target);
        }
        
        for(int x : arr.get(target)){
            if(x != parent){
                helper(x,target,k-1,arr);
            }
        }
    }
    
    private void dfs(TreeNode root,ArrayList<ArrayList<Integer>> arr){
        if(root == null){
            return;    
        }
        if(root.left!=null){
            arr.get(root.val).add(root.left.val);
            arr.get(root.left.val).add(root.val);
        }
        if(root.right!=null){
            arr.get(root.val).add(root.right.val);
            arr.get(root.right.val).add(root.val);
        }
        dfs(root.left,arr);
        dfs(root.right,arr);
    }
    
    private void num(TreeNode root){
        if(root == null)  return;
        max = Math.max(root.val,max);
        num(root.left);
        num(root.right);
    }
}