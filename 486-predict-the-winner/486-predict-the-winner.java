class Solution {
    int[][] dp;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int sum = 0;
        for(int x : nums){
            sum  = sum + x;
        }
        int res = fun(0,nums.length-1,nums);
        System.out.println(res);
        if(res >= sum - res){
            return true;
        }
        return false;
    }
    
    int fun(int i,int j,int[] nums){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        //if player 1 takes the first number
        int first = nums[i] + Math.min(fun(i+1,j-1,nums),fun(i+2,j,nums));
        
        //if player 1 takes the last number
        int sec = nums[j] + Math.min(fun(i+1,j-1,nums),fun(i,j-2,nums));
        
        return dp[i][j] = Math.max(first,sec);
        
    }
}