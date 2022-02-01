class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> st = new Stack<>();
        String[] arr = preorder.split(",");
        for(int i = 0;i<arr.length;i++){
            String item = arr[i];
            if(item.equals("#")){
                while(!st.isEmpty() && st.peek().equals("#")){
                    st.pop();
                    if(st.isEmpty()){
                        return false;
                    }
                    st.pop();
                }
            }
            st.push(item);
            
        }
        
        if(st.size() == 1){
            if(st.peek().equals("#")){
                return true;
            }
        }
        
        return false;
    }
}