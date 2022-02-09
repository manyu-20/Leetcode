class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][3][3];
        for(int i = 0;i<prices.length;i++){
            for(int j = 0;j<3;j++){
                for(int k = 0;k<3;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return fun(0,2,0,prices);
    }
    
    int fun(int index,int k,int buy,int[] prices){
        if(index >= prices.length || k <= 0){
            return 0;
        }
        
        if(dp[index][k][buy] != -1){
            return dp[index][k][buy];
        }
        
        if(buy == 0){
            return dp[index][k][buy] = Math.max(
            fun(index + 1,k,1,prices) - prices[index],
            fun(index + 1,k,0,prices)
            );
        }
        
        else{
            return dp[index][k][buy] = Math.max(
            fun(index + 1,k-1,0,prices) + prices[index],
            fun(index + 1,k,1,prices)
            );
        }
    }
}