class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int r = board.length;
        int c = board[0].length;
        Set<String> result = new HashSet<>();
        
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                for(String word : words) {
                    if(board[i][j] == word.charAt(0) && dfs(board, word, new boolean[r][c], i, j, 0)) {
                        result.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if(word.length() == index)
            return true;
        
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || visited[i][j] || board[i][j] != word.charAt(index))
            return false;
        
        visited[i][j] = true;
        
        if( dfs(board, word, visited, i+1, j, index+1) ||
            dfs(board, word, visited, i-1, j, index+1) ||
            dfs(board, word, visited, i, j+1, index+1) ||
            dfs(board, word, visited, i, j-1, index+1)
          )
            return true;
        
        visited[i][j] = false;
        
        return false;
    }
}