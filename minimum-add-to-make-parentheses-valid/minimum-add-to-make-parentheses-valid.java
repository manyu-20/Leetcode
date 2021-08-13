class Solution {
    public int minAddToMakeValid(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push('(');
            }
            else{
                if(st.isEmpty()){
                    count++;
                }
                else{
                    while(!st.isEmpty() && st.peek() != '('){
                        st.pop();
                    }
                    if(!st.isEmpty() && st.peek() == '('){
                        st.pop();
                    }
                    else{
                        count++;
                    }
                }
            }
        }
        
        count = count + st.size();
        return count;
    }
}