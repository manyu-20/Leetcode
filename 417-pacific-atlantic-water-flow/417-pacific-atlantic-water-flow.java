class Solution {
    static List<List<Integer>> ll;
    static boolean[][] pacific;
    static  boolean[][] arctic;
    static int n,m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ll = new ArrayList<>();
        n = heights.length;
        m = heights[0].length;
        pacific = new boolean[n][m];
        arctic = new boolean[n][m];
        
        for(int i = 0;i<n;i++){
            Arrays.fill(pacific[i],false);
            Arrays.fill(arctic[i],false);
        }
        
        // top to down
            // static void dfs(int i,int j,boolean[][] ocean,int prev,int[][] heights){
        int max = Integer.MIN_VALUE;
        for(int i =0 ;i<n;i++){
            dfs(i,0,pacific,max,heights);
            dfs(i,m-1,arctic,max,heights);
            
        }
        
        //left to right
        
        for(int i = 0;i<m;i++){
            dfs(0,i,pacific,max,heights);
            dfs(n-1,i,arctic,max,heights);
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(pacific[i][j] && arctic[i][j]){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    ll.add(new ArrayList<>(arr));
                }
            }
        }
        return ll;
    }
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    static void dfs(int i,int j,boolean[][] ocean,int prev,int[][] heights){
        if(i < 0 || j < 0 || i >= n || j >= m || ocean[i][j]  || heights[i][j] < prev){
            return;
        }
        ocean[i][j] = true;
        for(int[] arr : dir ){
            int x = i;
            int y = j;
            x = x + arr[0];
            y = y + arr[1];
            dfs(x,y,ocean,heights[i][j],heights);
        }
        
    }
}