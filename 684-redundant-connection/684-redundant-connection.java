class Solution {
    static int[] parent;
    static int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i = 0;i<=n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int[] i : edges){
            if(union(i[0],i[1])){
                return new int[]{i[0],i[1]};
            }
        }
        
        return new int[]{};
        
        
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