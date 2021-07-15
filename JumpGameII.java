class Solution {
    
    public int jump(int[] nums) {
       long dp[] = new long[nums.length+1];
        Arrays.fill(dp,-1);
        return (int)fun(nums,0,nums.length-1,dp);
    }
    private long fun(int[] nums,int curr,int dest,long[] dp){
        if(curr >= dest){
            return 0;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        long min = Integer.MAX_VALUE;
        for(int i = 1;i<=nums[curr];i++){
            if(i+curr>dest) break;
            min = Math.min(min,1 + fun(nums,curr+i,dest,dp));
        }
        dp[curr] = min;
        return min;
    }
}
