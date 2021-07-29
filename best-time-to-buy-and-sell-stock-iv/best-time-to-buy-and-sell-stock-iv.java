class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        if(prices == null){
            return 0;
        }
        int n = prices.length;
        if(n == 0 || k == 0){
            return 0;
        }
        if(k >= n/2){
             int ans = 0;
              for(int i = 1 ; i < n ; i++){
                  if(prices[i] > prices[i-1]){
                      ans += prices[i] - prices[i - 1];
                  }
              }
              return ans;
           }
        int flag = 0;
        dp = new int[k+1][3][n+1];
        return fun(prices,k,0,0);
        
        
    }
    
    private int fun(int[] prices,int k,int flag,int index){
        if(index >= prices.length || k == 0){
            return 0;
        }
        if(dp[k][flag][index] != 0){
            return dp[k][flag][index];
        }
        int buy = 0,nobuy = 0;
        int sell = 0,nosell = 0;
        if(flag == 0){
            buy = fun(prices,k,1,index+1) - prices[index];
            nobuy = fun(prices,k,0,index+1);
        }
        else{
            sell = fun(prices,k-1,0,index+1) + prices[index];
            nosell = fun(prices,k,1,index+1);   
        }
        return dp[k][flag][index] = Math.max(Math.max(buy,nobuy),Math.max(sell,nosell));
    }
}