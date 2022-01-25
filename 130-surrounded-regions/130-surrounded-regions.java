class Solution {
    static int n,m;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        if(n == 1 || m == 1){
            return;
        }
        if(n < 3 || m < 3 ){
            return;
        }
        for(int i = 0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board);
            }
            if(board[i][m-1] == 'O'){
                dfs(i,m-1,board);
            }
        }
        
        for(int i = 1;i<m-1;i++){
            if(board[0][i] == 'O'){
                dfs(0,i,board);
            }
            if(board[n-1][i] == 'O'){
                dfs(n-1,i,board);
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == '?'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static void dfs(int i,int j,char[][] board){
        if(i < 0 || j < 0 || i>=n || j >=m || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '?';
        for(int[] d : dir){
            int x = d[0] + i;
            int y = d[1] + j;
            dfs(x,y,board);
        }
    }
}