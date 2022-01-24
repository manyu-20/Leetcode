class Solution {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] vis;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        arr = new ArrayList<>();
        vis = new boolean[n+1];
        Arrays.fill(vis,false);
        for(int i = 0;i<=n;i++){
            arr.add(new ArrayList<>());
        }
        int start = 1;
        for(int[] i : isConnected){
            int neighbors = 1;
            for(int x : i){
                if(start != neighbors){
                    
                
                if(x == 1){
                    int u = start;
                    int v = neighbors;
                    // System.out.println(u + " " + v);
                    arr.get(u).add(v);
                }
                }
                neighbors++;
            }
            start++;
        }
        int count = 0;
        for(int i = 1;i<=n;i++){
            if(!vis[i]){
                
                count++;
                dfs(i);
            }
        }
        
        return count;
    }
    
    static void dfs(int node){
        vis[node] = true;
        
        for(int x : arr.get(node)){
            if(!vis[x]){
                
                dfs(x);
            }
        }
    }
}