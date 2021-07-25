class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
            
        int[][] dp = new int[n+1][m+1];
        if(matrix.length == 1 && matrix[0].length == 1){
            if(matrix[0][0] == '0'){
                return 0;
            }
            else return 1;
        }
        int max = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(matrix[i-1][j-1] == '1'){
                    int min = Math.min(dp[i-1][j],dp[i-1][j-1]);
                    min = Math.min(dp[i][j-1],min);
                    dp[i][j] = 1 + min;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
        
    }
}