class LRUCache {
    HashMap<Integer,Node> hm;
    int capacity;
    Node start,end;
    class Node{
        Node next,prev;
        int key,val;
        Node(int _key,int _val){
            key = _key;
            val = _val;
        }
    }
    
    public LRUCache(int _capacity) {
        capacity = _capacity;
        hm = new HashMap<>();
        start = new Node(0,0);
        end = new Node(0,0);
        start.next = end;
        end.prev = start;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            remove(node);
        }
        
        if(hm.size() == capacity){
            remove(end.prev);
        }
        insert(new Node(key,value));
    }
    
    void insert(Node node){
        int key = node.key;
        int val = node.val;
        hm.put(key,node);
        
        Node headNext = start.next;
        start.next = node;
        node.prev = start;
        headNext.prev = node;
        node.next = headNext;
    }
    
    void remove(Node node){
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // node.next = null;
        // node.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */