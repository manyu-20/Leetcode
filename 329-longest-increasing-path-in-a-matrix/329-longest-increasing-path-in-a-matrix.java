class Solution {
    static int[][] dp ;
    public int longestIncreasingPath(int[][] matrix) {
        dis = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int max = 1;
        dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0;i<=matrix.length;i++){
            Arrays.fill(dp[i],-1);
        }
            
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                for(int k = 0;k<matrix.length;k++){
                    Arrays.fill(vis[k],false);
                }
                max = Math.max(max,1 + dfs(matrix,i,j,vis));
            }
        }
        return max;
    }
    static int[][] dis;
    private int dfs(int[][]  matrix,int i,int j,boolean[][] vis){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int[] res =  new int[4];
        vis[i][j] = true;
        int max = 0;
        int index = 0;
        for(int[] d : dis){
            int x = i+d[0];
            int y = j+d[1];
            if(x >= 0 && y>=0 && x < matrix.length && y < matrix[0].length && !vis[x][y] && matrix[x][y] > matrix[i][j] ){
                res[index++] = 1 + dfs(matrix,x,y,vis);
                vis[x][y] = false;
            }
        }
        
        for(int k = 0;k<res.length;k++){
            max = Math.max(max,res[k]);
        }
        
        return dp[i][j] =  max;
        
    }
}