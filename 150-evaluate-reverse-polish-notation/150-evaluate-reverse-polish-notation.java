class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i<tokens.length;i++){
            String take = tokens[i];
            if(take.equals("+") || take.equals("-") || take.equals("*") || take.equals("/")){
                int first = st.pop();
                int sec = st.pop();
                int res = fun(sec,first,take);
                st.push(res);
            }
            else{
                st.push(Integer.parseInt(take));
            }
        }
        
        return st.peek();
    }
    
    int fun(int a,int b,String op){
        if(op.equals("+")){
            return a + b;
        }
        if(op.equals("-")){
            return a - b;
        }
        if(op.equals("*")){
            return a * b;
        }
        else{
            return a / b;
        }
    }
}