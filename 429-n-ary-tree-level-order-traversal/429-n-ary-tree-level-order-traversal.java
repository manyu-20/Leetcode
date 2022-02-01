/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null){
            return ls;
        }
        LinkedList<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<n;i++){
                Node pop = q.remove();
                list.add(pop.val);
                
                for(Node x : pop.children){
                    q.add(x);
                }
    
            }
            if(list.size() != 0){
                ls.add(new ArrayList<>(list));
            }
        }
        
        return ls;
    }
}