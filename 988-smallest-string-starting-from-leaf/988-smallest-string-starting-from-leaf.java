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
    StringBuilder sb;
    static char[] alpha;
    public String smallestFromLeaf(TreeNode root) {
        alpha = new char[26];
        for(char c = 'a';c<='z';c++){
            alpha[c - 'a'] = c;
        }
        sb = new StringBuilder("-1");
        fun(root,new StringBuilder(""));
        return sb.toString();
        
    }
    
    void fun(TreeNode root,StringBuilder temp){
        if(root == null){
            return;
        }
        char val = alpha[root.val];
        temp.append(val);
        if(root.left == null && root.right == null){
            check(temp.reverse());
            return;
        }
        fun(root.left,new StringBuilder(temp.toString()));
        fun(root.right,new StringBuilder(temp.toString()));
    }
    
    void check(StringBuilder temp){
        if(sb.toString().equals("-1")){
            sb = new StringBuilder(temp.toString());
            return;
        }
        String first = sb.toString();
        String sec = temp.toString();
        if(first.compareTo(sec) <= 0){
            sb = new StringBuilder(first.toString());
        }
        else{
            sb = new StringBuilder(sec.toString());
        }
    }
}