class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][3];
        for(int i = 0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,prices,fee,0);
    }
    
    int fun(int index,int[] prices,int fee,int buy){
        if(index >= prices.length){
            return 0;
        }
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        if(buy == 0){
            return dp[index][buy] = Math.max(
            fun(index + 1,prices,fee,1) - prices[index],
            fun(index + 1,prices,fee,0)
            );
        }
        
        else{
            return dp[index][buy] = Math.max(
            fun(index + 1,prices,fee,0) + prices[index] - fee,
            fun(index + 1,prices,fee,1)
            );
        }
        
    }
}