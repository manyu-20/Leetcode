class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][3];
        for(int i = 0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,0,prices);
    }
    
    int fun(int index,int buy,int[] prices){
        if(index >= prices.length){
            return 0;
        }
        
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        
        if(buy == 0){
            return dp[index][buy] =  Math.max(
            fun(index + 1,1,prices) - prices[index],
            fun(index + 1,0,prices)
            );
        }
        
        else{
            return dp[index][buy] =  Math.max(
            fun(index + 2,0,prices) + prices[index],
            fun(index + 1,1,prices)    
            );
        }
    }
}