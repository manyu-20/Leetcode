class Solution {
    static int[] parent;
    static int[] rank;
    public boolean equationsPossible(String[] equations) {
        HashMap<String,Integer> hm = new HashMap<>();
        int n = 0;
        for(String str : equations ){
            char[] arr = str.toCharArray();
                String a = String.valueOf(arr[0]);
                String b = String.valueOf(arr[3]);
                if(!hm.containsKey(a)){
                    hm.put(a,n);
                    n++;
                }
                if(!hm.containsKey(b)){
                    hm.put(b,n);
                    n++;
                }
            
        }
        
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
         for(String str : equations ){
            char[] arr = str.toCharArray();
                String a = String.valueOf(arr[0]);
                String middle = String.valueOf(arr[1]);
                String b = String.valueOf(arr[3]);
                if(middle.equals("=")){
                    union(hm.get(a),hm.get(b));
                }
        
         }
        
        for(String str : equations ){
           char[] arr = str.toCharArray();
                String a = String.valueOf(arr[0]);
                String middle = String.valueOf(arr[1]);
                String b = String.valueOf(arr[3]);
                if(middle.equals("!")){
                    if(!remove(hm.get(a),hm.get(b))){
                        return false;
                    }
                }
        
         }
        return true;
        
    }
    
    static void union(int u,int v){
        u = find(u);
        v = find(v);
        
        if(rank[u] < rank[v]){
            parent[u] = v;
        }
        else if(rank[u] > rank[v]){
            parent[v] = u;
        }
        else{
            parent[v] = u;
            rank[u] = rank[u] + 1;
        }
    }
    
    static boolean remove(int u,int v){
        u = find(u);
        v = find(v);
        if(u == v){
            return false;
        }
        return true;
    }
    static int find(int node){
        if(node == parent[node]){
            return node;
        }
        
        return parent[node] = find(find(parent[node]));
    }
}