class Solution {
    static class pair{
        int x,y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[] dailyTemperatures(int[] t) {
        int len = t.length;
        Stack<pair> st = new Stack<>();
        int[] ans = new int[len];
        int index = len - 1;
        for(int i = len-1;i>=0;i--){
            int ele = t[i];
            // if(st.isEmpty()){
            //     ans[index] = 0;
            // }
                int count = 1;
               while(!st.isEmpty() && st.peek().x<=ele ) {
                   int val = st.pop().y;
                   count = count + val;
               }
                if(st.isEmpty()){
                    ans[index] = 0;
                    st.push(new pair(ele,0));
                }
                else{
                    ans[index] = count;
                    st.push(new pair(ele,count));
                }
            // st.push(ele);
            index--;
            
        }
        return ans;
    }
}