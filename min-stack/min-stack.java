class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        if(!st.isEmpty()){
         st.pop();
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
         return st.peek();
        }
        return 0;
    }
    
    public int getMin() {
        return small(st,Integer.MAX_VALUE);
    }
    
    private int small(Stack<Integer> st,int min){
        if(st.isEmpty()){
            return min;
        }
        int pop = st.pop();
        min = Math.min(pop,min);
        min = Math.min(min,small(st,min));
        st.push(pop);
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */