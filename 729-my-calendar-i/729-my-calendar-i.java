class MyCalendar {
    
    class Node{
        int start,end;
        Node left,right;
        Node(int _start,int _end){
            start = _start;
            end = _end;
        }
    }
    
    Node root;
    public MyCalendar() {
        root = null;
    }
    
    public boolean book(int start, int end) {
        if(root == null){
            root = new Node(start,end);
            return true;
        }
        else{
            return add(root,start,end);
        }
    }
    
    private boolean add(Node root,int start,int end){
        if(root.start >= end){
            if(root.left == null){
                root.left = new Node(start,end);
                return true;
            }
            else{
                return add(root.left,start,end);
            }
        }
        if(root.end <= start){
            if(root.right == null){
                root.right = new Node(start,end);
                return true;
            }
            else{
                return add(root.right,start,end);
            }
        }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */