class Solution {
    int mod = 1_000_000_007;
    int[] dp;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fun(1,n,delay,forget);
    }
    
    int fun(int curr,int last,int delay,int forget){
        if(delay == forget){
            return 1;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        
        int ans = 0;
        
        if(curr + forget > last){
            ans = 1;
        }
        
        for(int i = curr + delay;i < Math.min(last+1,curr + forget);i++){
            ans = (ans % mod + fun(i,last,delay,forget) % mod) % mod;
        }
        
        return dp[curr] = ans % mod;
    }
}