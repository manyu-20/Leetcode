class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(fun(0,cost),fun(1,cost));
    }
    
    int fun(int i,int[] cost){
        if(i >= cost.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int one = fun(i+1,cost) + cost[i];
        int two = fun(i+2,cost) + cost[i];
        
        return dp[i] = Math.min(one,two);
    }
}