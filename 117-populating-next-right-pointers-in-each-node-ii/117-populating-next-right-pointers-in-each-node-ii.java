/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            Node curr = null;
            for(int i = 0;i<n;i++){
                Node pop =  q.remove();
                pop.next = curr;
                curr = pop;
                if(pop.right != null){
                    q.add(pop.right);
                }
                if(pop.left != null){
                    q.add(pop.left);
                }
                
            }
        }
        
        return root;
    }
}