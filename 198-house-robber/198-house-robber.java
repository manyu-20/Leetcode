class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp,-1);
        return sum(0,nums);
        
    }
    
    int sum(int index,int[] nums){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int take = nums[index];
        
        take = take + sum(index + 2,nums);
        
        int dontTake = sum(index + 1,nums);
        
        return dp[index] = Math.max(take,dontTake);
    }
}