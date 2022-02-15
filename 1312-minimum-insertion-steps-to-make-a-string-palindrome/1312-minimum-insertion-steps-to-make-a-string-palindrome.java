class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int n1 = s.length();
        int[][] dp = new int[n1+1][n1+1];
        
        for(int i = 1;i<=n1;i++){
            for(int j = 1;j<=n1;j++){
                if(s.charAt(i-1) == sb.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        int i = n1;
        int j = n1;
        StringBuilder longest = new StringBuilder("");
        
        while(i > 0 && j > 0){
            if(s.charAt(i-1) == sb.charAt(j-1)){
                longest.append(s.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        
        return Math.abs(longest.length() - n1);
    }
}