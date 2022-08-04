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
        LinkedList<Node> ll = new LinkedList<>();
        if(root == null){
            return null;
        }
        ll.offer(root);
        root.next = null;
        while(!ll.isEmpty()){
            int size = ll.size();
            Node nxt = null;
            for(int i = 0;i<size;i++){
                Node pop = ll.poll();
                pop.next = nxt;
                nxt = pop;
                Node left = pop.left;
                Node right = pop.right;
                if(right != null){
                    ll.addLast(right);
                }
                if(left != null){
                    ll.addLast(left);
                }
            }
            
        }
        return root;
    }
}