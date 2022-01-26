class Solution {
    static int n,m;
    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        for(int i = 0;i<n;i++){
            if(grid[i][0] == 0){
                dfs(i,0,grid);
            }
            if(grid[i][m-1] == 0){
                dfs(i,m-1,grid);
            }
        }
        
        for(int i = 0;i<m;i++){
            if(grid[0][i] == 0){
                dfs(0,i,grid);
            }
            if(grid[n-1][i] == 0){
                dfs(n-1,i,grid);
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 0){
                    count++;
                    dfs2(i,j,grid);
                }
            }
        }
        return count;
        
    }
    
    static void dfs2(int i,int j,int[][] grid){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 0){
            return;
        }
        grid[i][j] = 2;
        for(int[] d : dir){
            int x = d[0] + i;
            int y = d[1] + j;
            dfs(x,y,grid);
        }
    }
    
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    static void dfs(int i,int j,int[][] grid){
        if(i < 0 || j < 0 ||  i>= n || j >= m || grid[i][j] != 0){
            return;
        }
        grid[i][j] = 2;
        for(int[] d : dir){
            int x = d[0] + i;
            int y = d[1] + j;
            dfs(x,y,grid);
        }
    }
}