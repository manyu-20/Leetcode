class Solution {
    static int[] parent;
    static int[] rank;
    public int makeConnected(int n, int[][] connections) {
        int minReq = n-1;
        int given = connections.length;
        if(given < minReq){
            return -1;
        }
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        int gain = 0;
        int connected = 0;
        for(int[] i : connections){
            if(union(i[0],i[1])){
                gain++;
            }
            else{
                connected++;
            }
        }
        
        if(minReq - connected > gain){
            return -1;
        }
        else return Math.min(minReq - connected,gain);
        
        
    }
    
    static boolean union(int u,int v){
        u = find(u);
        v = find(v);
        if(u == v){
            return true;
        }
        if(rank[u] < rank[v]){
            parent[u] = v;
        }
        else if(rank[u] > rank[v]){
            parent[v] = u;
        }
        else{
            parent[u] = v;
            rank[v] = rank[v] + 1;
        }
        return false;
    }
    
    static int find(int node){
        if(node == parent[node]){
            return node;
        }
        
        return parent[node] = find(parent[node]);
    }
}