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

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        int parentX = -1;
        int parentY = -1;
        int levelX = -1;
        int levelY = -1;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0;i<n;i++){
                TreeNode pop = q.remove();
                if(pop.val == x){
                    levelX = level;
                }
                if(pop.val == y){
                    levelY = level;
                }
                if(pop.left != null){
                    if(pop.left.val == x){
                        parentX = pop.val;
                    }
                    if(pop.left.val == y){
                        parentY = pop.val;
                    }
                    q.add(pop.left);
                }
                if(pop.right != null){
                     if(pop.right.val == x){
                        parentX = pop.val;
                    }
                    if(pop.right.val == y){
                        parentY = pop.val;
                    }
                    q.add(pop.right);
                }
            }
            level++;
        }
        System.out.println(parentX + " " + parentY  + " " + levelX + " " + levelY);
        if(parentX != -1 && parentY != -1 && levelX != -1 && levelY != -1){
            return levelX == levelY && parentX != parentY;
        }
        else{
            return false;
        }
    }
    

}