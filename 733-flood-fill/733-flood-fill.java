class Solution {
    static boolean[][] vis;
    static int n,m;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        n = image.length;
        m = image[0].length;
        vis = new boolean[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(vis[i],false);
        }
        
        int i = sr;
        int j = sc;

        LinkedList<pair> ll = new LinkedList<>();
        ll.add(new pair(i,j));
        
        while(!ll.isEmpty()){
            i = ll.peek().x;
            j = ll.peek().y;
            ll.remove();
            image[i][j] = newColor;
            vis[i][j] = true;
            if(isSafe(i,j-1) && image[i][j-1] == oldColor){
                ll.add(new pair(i,j-1));
            }
            if(isSafe(i-1,j) && image[i-1][j] == oldColor){
                ll.add(new pair(i-1,j));
            }
            if(isSafe(i,j+1) && image[i][j+1] == oldColor){
                ll.add(new pair(i,j+1));
            }
            if(isSafe(i+1,j) && image[i+1][j] == oldColor){
                ll.add(new pair(i+1,j));
            }
        }
        
        return image;
        
    }
    
    static class pair{
        int x,y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    

    
    static boolean isSafe(int i ,int j){
        return i>=0 && j >=0 && i<n && j < m && !vis[i][j];
    }
}