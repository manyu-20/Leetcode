class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] t : connections){
            int u = t[0];
            int v = t[1];
            list.get(u).add(v);
            list.get(v).add(-1*u);
        }
        
        boolean[] vis = new boolean[n];
        Arrays.fill(vis,false);
        return dfs(list,vis,0);

    }
    
    static int dfs(List<List<Integer>> list,boolean[] vis,int start){
        vis[start] = true;
        int res = 0;
        
        for(int n : list.get(start)) {
            if(!vis[Math.abs(n)]){
                if(n > 0){
                    res = res + 1;
                }
                res = res + dfs(list,vis,Math.abs(n));
            }
        }
        
        return res;
    }
}