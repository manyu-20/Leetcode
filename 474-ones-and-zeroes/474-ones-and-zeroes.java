class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length+1][n+1][m+1];
        for(int i = 0;i<=strs.length;i++){
            for(int j = 0;j<=n;j++){
                for(int k = 0;k<=m;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return fun(strs,0,n,m);
        
    }
    
    int fun(String[] items,int index,int n,int m){
        if(index >= items.length){
            return 0;
        }
        if(n < 0 || m < 0){
            return 0;
        }
        
        if(dp[index][n][m] != -1){
            return dp[index][n][m];
        }
        
        int ones = 0;
        for(int i = 0;i<items[index].length();i++){
            if(items[index].charAt(i) == '1'){
                ones++;
            }
        }
        int zeros = items[index].length() - ones;
        
        if(m >= zeros && n>=ones){
            return dp[index][n][m]= Math.max(1 + fun(items,index+1,n-ones,m-zeros),fun(items,index+1,n,m));
        }
        else{
            return dp[index][n][m] =  fun(items,index + 1,n,m);
        }
    }
}