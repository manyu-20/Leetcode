class Solution {
    public int removeStones(int[][] stones) {
        HashSet<int[]> visited = new HashSet<>();
        int num = 0;
        for(int[] i : stones){
            if(!visited.contains(i)){
                num++;
                dfs(i,visited,stones);
            }
        }
        
        return stones.length - num;
    }
    
    static void dfs(int[] i,HashSet<int[]> vis,int[][] stones){
        vis.add(i);
        
        for(int[] st : stones){
            int u = st[0];
            int v = st[1];
            if(!vis.contains(st) && (i[0] == u || i[1] == v)){
                dfs(st,vis,stones);
            }
        }
    }
}