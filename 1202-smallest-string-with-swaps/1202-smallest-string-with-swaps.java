
class Solution {
    static int[] parent;
    static int[] rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(List<Integer> ls : pairs){
            int u = ls.get(0);
            int v = ls.get(1);
            union(u,v);
        }
        HashMap<Integer,PriorityQueue<Character>> hm = new HashMap<>();
        
        for(int i = 0;i<n;i++){
            int par = find(i);
            if(!hm.containsKey(par)){
                hm.put(par,new PriorityQueue<>((a,b) -> a-b));
            }
            
                hm.get(par).add(s.charAt(i));
            
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<n;i++){
            int par = parent[i];
            char c = hm.get(find(i)).poll();
            sb.append(c);
        }
        
        return sb.toString();
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
            parent[u] = v;
            rank[v]++;
        }
    }
    
    static int find(int node){
        if(node == parent[node]){
            return node;
        }
        
        return parent[node] = find(parent[node]);
    }
}