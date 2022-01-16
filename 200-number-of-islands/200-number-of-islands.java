class Solution {
    static boolean vis[][];
    static int n,m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(vis[i],false);
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        
        return count;
        
    }
    
    static void dfs(int i,int j,char[][] grid){
        if(!isSafe(i,j) || grid[i][j] == '0'){
            return;
        }
        vis[i][j] = true;
        
        dfs(i,j-1,grid);
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        
    }
    

    static boolean isSafe(int i,int j){
        return i >= 0 && j>= 0 && i < n && j < m && !vis[i][j];
    }
}