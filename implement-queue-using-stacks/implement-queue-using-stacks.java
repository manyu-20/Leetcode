class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> main;
    Stack<Integer> temp;
    public MyQueue() {
        main = new Stack<>();
        temp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(main.isEmpty()){
            main.push(x);
        }
        else{
            while(!main.isEmpty()){
                temp.push(main.pop());
            }
            main.push(x);
            while(!temp.isEmpty()){
                main.push(temp.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!empty()){
            return main.pop();
        }
        return -1;
    }
    
    /** Get the front element. */
    public int peek() {
        if(!empty()){
            return main.peek();
        }
        return -1;
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(main.isEmpty()){
            return true;
        }
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */