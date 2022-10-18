class Solution {
    public String countAndSay(int n) {
        return fun(1,n,"1");
    }
    
    String fun(int i,int n,String start){
        if(i == n){
            return start;
        }
        StringBuilder sb = new StringBuilder("");
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int itr = 0;itr<start.length();itr++){
            String val = String.valueOf(start.charAt(itr));
            int num = Integer.parseInt(val);
            st.push(num);
        }

        while(true){
            int val = st.peek();
            int count = 0;
            while(!st.isEmpty() && st.peek() == val){
                st.pop();
                count++;
            }
            String temp = count +""+val;
            int index = sb.length() - 1;
            // System.out.println( start + "  " + temp);
            // if(index < 0){
            //     index = 0;
            // }
            sb.insert(0,temp);
            if(st.size()<= 1){
                break;
            }
        }

        // System.out.println( i + "  " + sb);
        return fun(i+1,n,sb.toString());
        
        
    }
}