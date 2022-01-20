class Solution {
    public int[] findOrder(int numCourses, int[][] p) {
        int n = numCourses;
        ArrayList[] arr = new ArrayList[n+1];
        for(int i = 0;i<arr.length;i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int[] i : p){
            int start = i[0];
            int end = i[1];
            arr[start].add(end);
        }
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[n+1];
        boolean[] curr = new boolean[n+1];
        Arrays.fill(vis,false);
        Arrays.fill(curr,false);
        for(int i = 0;i<n;i++){
            if(!vis[i]){
               if(dfs(i,arr,st,vis,curr)){
                  return new int[] {};
               }
            }
        }
        
        int[] res = new int[st.size()];
        System.out.println(st);
        for(int i = 0;i<res.length;i++){
            res[i] = st.peek();
            st.pop();
        }
        
        int i = 0;
        int j = res.length-1;
        
        while(i < j){
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
        
        return res;
        
            
        
    }
    
    static boolean dfs(int node,ArrayList<Integer> arr[],Stack<Integer> st,boolean[] vis,boolean[] curr){
        vis[node] = true;
        curr[node] = true;
        for(int x : arr[node]){
            if(!vis[x]){
                if(dfs(x,arr,st,vis,curr)){
                    return true;
                }
            }
            else if(curr[x]){
                return true;
            }
        }
        
        st.push(node);
        curr[node] = false;
        return false;
    }
}