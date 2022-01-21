class Solution {
    static class pair{
        int dis,v;
        pair(int dis , int v){
            this.dis = dis;
            this.v = v;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] sec = new int[n+1];
        Arrays.fill(sec,Integer.MAX_VALUE);
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        
        ArrayList<pair>[] arr  = new ArrayList[n+1];
        
        for(int i = 0;i<=n;i++){
            arr[i] = new ArrayList<pair>();
        }
        
        for(int[] take : times){
            int u = take[0];
            int v = take[1];
            int w = take[2];
            arr[u].add(new pair(w,v));
        }
        sec[k] = 0;
        pq.add(new pair(0,k));
        
        while(!pq.isEmpty()){
            int dis = pq.peek().dis;
            int u = pq.peek().v;
            pq.remove();
            
            for(int i = 0;i<arr[u].size();i++){
                // System.out.println( arr[u].get(i).dis);
                pair neighbor = arr[u].get(i);
                if(neighbor.dis + dis < sec[neighbor.v]){
                    sec[neighbor.v] = neighbor.dis + dis;
                    pq.add(new pair(neighbor.dis + dis,neighbor.v));
                }
            }

        }
        int max = 0;
        for(int i = 1;i<=n;i++){
            // System.out.println(sec[i]);
            max = Math.max(max,sec[i]);
        }
        
        if(max == Integer.MAX_VALUE){
            return -1;
        }
        return max;
        
    }
}