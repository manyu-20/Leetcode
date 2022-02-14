class Solution {
    int n,m;
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        dp = new int[n+1][m+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0;i<m;i++){
            min = Math.min(min,fun(0,i,matrix));
        }
        
        
        
        return min;
    }
    int fun(int i,int j,int[][] matrix){
        if(j < 0 || j >= m){
            return Integer.MAX_VALUE;
        }
        if(i == n-1){
            return matrix[i][j];
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int first = fun(i+1,j-1,matrix);
        int second = fun(i+1,j,matrix);
        int third = fun(i+1,j+1,matrix);
        
        
        int min = matrix[i][j] + Math.min(first,Math.min(second,third));
        
        return dp[i][j] = min;

    }
    
    
    
}