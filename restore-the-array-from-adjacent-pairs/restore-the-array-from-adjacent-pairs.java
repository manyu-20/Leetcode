class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length;
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        
        for(int i = 0;i<len;i++){
            int u = adjacentPairs[i][0];
            int v = adjacentPairs[i][1];
            add(u,v,hm);
            add(v,u,hm);
        }
        
        int start = -1;
        
        for(int item : hm.keySet()){
            if(hm.get(item).size() == 1){
                start = item;
                break;
            }
        }
        
        ArrayList<Integer> container = new ArrayList<>();
        HashSet<Integer> vis = new HashSet<>();
        dfs(container,vis,hm,start);
        int[] ans = new int[len+1];
        for(int i = 0;i<ans.length;i++){
            ans[i] = container.get(i);
        }
        return ans;
        
    }
    
    void add(int u,int v,HashMap<Integer,ArrayList<Integer>> hm){
        if(hm.containsKey(u)){
            ArrayList<Integer> temp = hm.get(u);
            temp.add(v);
            hm.put(u,temp);
        }
        else{
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            hm.put(u,temp);
        }
    }
    
    void dfs(ArrayList<Integer> container,HashSet<Integer> hs,HashMap<Integer,ArrayList<Integer>> hm,int start){
        ArrayList<Integer> temp = hm.get(start);
        container.add(start);
        hs.add(start);
        for(int i = 0;i<temp.size();i++){
            int destination = temp.get(i);
            if(!hs.contains(destination)){
                dfs(container,hs,hm,destination);
            }
        }
    }
}