class Solution {
    static int n,m;
    public int numEnclaves(int[][] grid) {
         n = grid.length;
         m = grid[0].length;
        
//         if(n == 1 || m == 1){
//             boolean is = false;
//             for(int i = 0;i<n;i++){
//                 if(grid[i][0] == 1){
//                     is = true;
//                     break;
//                 }
//             }
            
//             for(int j = 0;j<m;j++){
//                 if(grid[0][j] == 1){
//                     is = true;
//                     break;
//                 }
//             }
            
//             if(is)return Math.max(n,m);
//             else return 0;
            
//         }
        
        for(int i = 0;i<n;i++){
            if(grid[i][0] == 1){
                dfs(i,0,grid);
            }
            if(grid[i][m-1] == 1){
                dfs(i,m-1,grid);
            }
        }
        
        for(int i = 0;i<m;i++){
            if(grid[0][i] == 1){
                dfs(0,i,grid);
            }
            if(grid[n-1][i] == 1){
                dfs(n-1,i,grid);
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    static void dfs(int i,int j,int[][] graph){
        if(i < 0 || j <0 || i >= n || j >= m || graph[i][j] != 1){
            return;
        }
        graph[i][j] = 2;
        for(int[] d : dir){
            int x = d[0] + i;
            int y = d[1] + j;
            
            dfs(x,y,graph);
        }
    }
    
    
}