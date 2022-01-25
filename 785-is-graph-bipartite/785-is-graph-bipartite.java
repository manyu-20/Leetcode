class Solution {
    public boolean isBipartite(int[][] graph) {
        LinkedList<Integer> ll = new LinkedList<>();
        int n = graph.length;
        int[] color = new int[n];
        
        Arrays.fill(color,-1);

        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                color[i] = 0;
                ll.add(i);
                while(!ll.isEmpty()){
            int parent = ll.pop();
            for(int neighbor : graph[parent]){
                if(color[neighbor] == -1){
                    
                    if(color[parent] == 0){
                        color[neighbor] = 1;
                    }
                    else{ color[neighbor] = 0;}
                    ll.add(neighbor);
                    
                }
                else if(color[parent] == color[neighbor]){
                    return false;
                }
            }
        }
            }
        }
        
        return true;
            
    }
}