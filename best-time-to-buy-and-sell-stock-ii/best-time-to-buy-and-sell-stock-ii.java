class Solution {
    static int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length+1][3];
        for(int i = 0;i<=prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int index = 0;
        return fun(prices,index,0);
    }
    
    private int fun(int[] prices,int index,int take){
        if(index == prices.length){
            return 0;
        }
        if(dp[index][take] != -1){
            return dp[index][take];
        }
        int max = -1;
        if(take == 1){
            // sell it or leave it
            int first = prices[index] + fun(prices,index+1,0);
            int second = fun(prices,index+1,1);
            max = Math.max(first,second);
        }
        else{
            //buy it or leave it
            int first = fun(prices,index+1,1) - prices[index];
            max = Math.max(max,first);
            int sec = fun(prices,index+1,0);
            max = Math.max(max,sec);
        }
        return  dp[index][take] =  max;
        
    }
}