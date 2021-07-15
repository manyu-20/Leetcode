class Solution {
    static int n;
    static int m;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m] ;
        for(int i =0;i<n;i++){
            Arrays.fill(vis[i],false);
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                // vis[i][j] = true;
                if(grid[i][j] == 1 && !vis[i][j]){
                    max = Math.max(max,count(grid,i,j,vis));
                }
            }
        }
        return max;
    }
    
    private int count(int[][] grid,int i,int j,boolean[][] vis){
        if(!isSafe(i,j) || grid[i][j] == 0 || vis[i][j]){
            return 0;
        }
        vis[i][j] = true;
        int c = 1;
        if(isSafe(i-1,j) && grid[i-1][j] == 1){
            c = c +  count(grid,i-1,j,vis);
        }
        if(isSafe(i,j+1) && grid[i][j+1] == 1){
            c = c + count(grid,i,j+1,vis);
        }
        if(isSafe(i+1,j) && grid[i+1][j] == 1){
            c = c + count(grid,i+1,j,vis);
        }
        if(isSafe(i,j-1) && grid[i][j-1] == 1){
            c = c + count(grid,i,j-1,vis);
        }
        return c;
    }
    private boolean isSafe(int i,int j){
        return i >= 0 && j >=0 && i<n && j<m;
    }
}