class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];
        int[] after = new int[n];
        prev[0] = nums[0];
        for(int i = 1;i<n;i++){
            prev[i] = prev[i-1] * nums[i];
        }
        
        after[n-1] = nums[n-1];
        
        for(int i = n-2;i>=0;i--){
            after[i] = after[i+1] * nums[i];
        }
        
        int[] ans = new int[n];
        
        for(int i = 0;i<n;i++){
            if(i == 0)ans[i] = after[i+1];
            else if(i == n-1)ans[i] = prev[i-1];
            else ans[i] = prev[i-1] * after[i+1];
        }
        
        return ans;
    }
}