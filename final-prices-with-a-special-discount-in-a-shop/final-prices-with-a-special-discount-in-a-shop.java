class Solution {
    public int[] finalPrices(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                ans[st.pop()] = nums[i];
            }
            st.push(i);
        }
        
        for(int i = 0;i<n;i++){
            nums[i] = nums[i] - ans[i];
        }
        return nums;
        
    }
}