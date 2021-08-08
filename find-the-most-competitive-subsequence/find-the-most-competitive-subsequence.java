class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            int ele = nums[i];
            
                while(!st.isEmpty() && st.peek() > ele && st.size() + n - i > k){
                    st.pop();
                }
            if(st.size() < k)
            st.push(ele);
        }
        int i = k;
        int[] ans = new int[k];
        while(!st.isEmpty()){
            ans[--i] = st.pop();
        }
        return ans;
        
            
    }
}