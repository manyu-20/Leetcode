class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1){
            return nums[0];
        }
        dp = new int[n];
        Arrays.fill(dp,-1);
        int first = fun(0,nums,n-1);
        Arrays.fill(dp,-1);
        int second = fun(1,nums,n);
        
        return Math.max(first,second);
        
    }
    
    int fun(int index,int[] nums,int n){
        if(index >= n){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        return dp[index] = Math.max(nums[index]+fun(index+2,nums,n), fun(index+1,nums,n));
    }
}