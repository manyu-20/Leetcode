class Solution {
    int[][] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length][400];
        for(int i = 0;i<days.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,days,costs,0);
    }
    
    int fun(int index,int[] days,int[] cost,int validity){
        if(index >= days.length){
            return 0;
        }
        if(dp[index][validity] != -1){
            return dp[index][validity];
        }
        if(validity < days[index]){
            int first = cost[0] + fun(index + 1,days,cost,days[index] + 1 - 1);
            int second = cost[1] + fun(index + 1,days,cost,days[index] + 7 - 1);
            int third = cost[2] + fun(index + 1,days,cost,days[index] + 30 - 1);
            return dp[index][validity] = Math.min(first,Math.min(second,third));
        }
        else{
            return dp[index][validity] = fun(index + 1,days,cost,validity);
        }
    }
}