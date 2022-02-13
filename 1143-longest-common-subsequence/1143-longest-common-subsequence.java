class Solution {
    static int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n+1][m+1];
        
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
        return dp[n][m];
            
    }
    
    int max(String text1,String text2,int n,int m){
        if(n == 0 || m== 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        if(text1.charAt(n-1) == text2.charAt(m-1)){
                return dp[n][m] = 1 + max(text1,text2,n-1,m-1);
            
        }
        else{
            return  dp[n][m] =  Math.max(max(text1,text2,n-1,m),max(text1,text2,n,m-1));
        }
    }
}