class Solution {
    int n,m;
    int[][] dp;
    public int minPathSum(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n+1][m+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(grid,0,0);
        
    }
    
    int fun(int[][] grid,int i,int j){
        if(i < 0 || j < 0 || i>= n || j >=m){
            return 10000;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == n-1 && j == m-1){
            return grid[i][j];
        }
        
        return dp[i][j] =  grid[i][j] + Math.min(fun(grid,i+1,j),fun(grid,i,j+1));
    }
}