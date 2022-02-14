class Solution {
    int MOD = 1000000000 + 7;
    int[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n,k,target) % MOD;
    }
    
    int fun(int n,int k,int target){
        if(target == 0 && n == 0){
            return 1;
        }
        if(target < 0 || n < 0){
            return 0;
        }

        if(dp[n][target] != -1){
            return dp[n][target] % MOD;
        }
        int sum = 0;
        for(int i = 1;i<=k;i++){
            if(i <= target){
                sum = (sum % MOD + fun(n-1,k,target - i) % MOD) % MOD;
            }
        }
        
        return dp[n][target] = sum % MOD;
        
    }
}