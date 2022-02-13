class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int first = fun(n,1,nums);
        Arrays.fill(dp,-1);
        int sec = fun(n-1,0,nums);
        return Math.max(first,sec);
        
    }
    
    int fun(int n,int end,int[] nums){
        if(n <= end){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = Math.max(nums[n-1] + fun(n-2,end,nums),fun(n-1,end,nums));
    }
}