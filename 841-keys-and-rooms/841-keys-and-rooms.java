class Solution {
    static boolean[] vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int start = 0;
        vis = new boolean[rooms.size()];
        Arrays.fill(vis,false);
        int i = 0;
        dfs(0,rooms);
        for(boolean b : vis){
            if(!b){
                System.out.println(i);
                return false;
            }
            i++;
        }
        return true;
    }
    
    private static void dfs(int start,List<List<Integer>> rooms){
        vis[start] = true;
        for(int n : rooms.get(start)){
            if(!vis[n]){
                dfs(n,rooms);
            }
        }
    }
}