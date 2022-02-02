class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        TreeNode node1=null,node2=null;
        while(!q.isEmpty()){
            int n=q.size();
            boolean first=true;
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(first)node1=node;                              /*recording the first node in the particular level.*/
                first=false;
                node2=node;                                      /*gets updated to the very last node once it exits this loop.*/
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
        }
        return find_ancestor(root,node1,node2);
    }
    TreeNode find_ancestor(TreeNode node,TreeNode node1,TreeNode node2){
        if(node==null)return null;
        if(node==node1||node==node2)return node;
        TreeNode left=find_ancestor(node.left,node1,node2);
        TreeNode right=find_ancestor(node.right,node1,node2);
        if(left!=null&&right!=null)return node;
        if(left!=null)return left;
        return right;
    }
}