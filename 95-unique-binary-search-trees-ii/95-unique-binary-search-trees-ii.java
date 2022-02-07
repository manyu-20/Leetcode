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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if(n == 0){
            return list;
        }
        return fun(1,n);
        
    }
    
    List<TreeNode> fun(int start,int end){
        List<TreeNode> ls = new ArrayList<>();
        if(start > end){
            ls.add(null);
            return ls;
        }
        if(start == end){
            ls.add(new TreeNode(start));
            return ls;
        }
        
        for(int i = start;i<=end;i++){
            List<TreeNode> left = fun(start,i-1);
            List<TreeNode> right = fun(i+1,end);


            for(int x = 0;x<left.size();x++){
                for(int j = 0;j<right.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(x);
                    root.right = right.get(j);
                    ls.add(root);
                }
            }
        }
        
        return ls;
    }
}