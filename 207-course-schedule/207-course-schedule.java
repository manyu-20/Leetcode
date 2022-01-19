class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer> arr[] = new ArrayList[n+1];
        for(int i = 0;i<=n;i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int[] i : prerequisites){
            int start = i[0];
            int end = i[1];
            arr[start].add(end);
        }
        boolean[] vis = new boolean[n+1];
        boolean currDfs[] = new boolean[n+1];
        Arrays.fill(vis,false);
        Arrays.fill(currDfs,false);
        for(int i = 1;i<=n;i++){
            if(!vis[i]){
                if(dfs(i,arr,vis,currDfs)){
                    return false;
                }
            }
        }
        
        return true;
        
        
         
        
    }
    
    static boolean dfs(int node, ArrayList<Integer> arr[],boolean[] vis,boolean currDfs[]){
        vis[node] = true;
        currDfs[node] = true;
        
        for(int x : arr[node]){
            if(!vis[x]){
                if(dfs(x,arr,vis,currDfs)){
                    return true;
                }
            }
            else if(currDfs[x]){
                return true;
            }
        }
        
        currDfs[node] = false;
        
        return false;
        
    }
}