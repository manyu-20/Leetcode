class Solution {
    public int rob(int[] nums) {
        // return fun(nums.length-1,nums);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for(int i = 1;i<n;i++){
            int left = nums[i];
            if(i - 2 >=0){
                left = left + dp[i-2];
            }
            int right = dp[i-1];
            dp[i] = Math.max(left,right);
        }
        
        return dp[n-1];
    }
    
    int fun(int index,int[] nums){
        if(index == 0){
            return nums[index];
        }
        int left = 0;
        if(index - 2 >= 0){
        left = fun(index - 2,nums) + nums[index];
        }
        int right = fun(index - 1,nums);
        return Math.max(left,right);
    }
    
}