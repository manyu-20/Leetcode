class Solution {
    static List<List<Integer>> list;
    static int[] col;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        list = new ArrayList<>();
        col = new int[n+1];
        Arrays.fill(col,-1);
        for(int i = 0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] d : dislikes){
            int u = d[0];
            int v = d[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        for(int i = 1;i<=n;i++){
            if(col[i] == -1){
                if(!dfs(i,1)){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    static boolean dfs(int start,int color){
        col[start] = color;
        
        for(int n : list.get(start)){
            if(col[n] == -1){
                if(color == 1){
                    if(!dfs(n,0)){
                        return false;
                    }
                }
                else if(color == 0){
                    if(!dfs(n,1)){
                        return false;
                    }
                }
            }
            else if(col[n] == col[start]){
                return false;
            }
        }
        
        return true;
    }
}