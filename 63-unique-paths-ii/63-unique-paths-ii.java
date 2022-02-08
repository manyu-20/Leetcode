class Solution {
    int[][] dp;
    int n,m;
    public int uniquePathsWithObstacles(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        if(grid[n-1][m-1] == 1){
            return 0;
        }
        return fun(0,0,grid);
    }
    
    int fun(int i,int j,int[][] grid){
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(i >= n || j >=m || i <0 || j <0 ){
            return 0;
        }
        if(grid[i][j] == 1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        return dp[i][j] = fun(i+1,j,grid) + fun(i,j+1,grid);
    }

}