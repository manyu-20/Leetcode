class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int i = 0;
        int n = stations.length;
        int start = startFuel;
        int res = 0;
        if(start >= target){
            return 0;
        }
        while(start < target){
            while(i < n && stations[i][0] <= start){
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.isEmpty()){
                return -1;
            }
            start = start + pq.remove();
            res++;
        }
        return res;
    }
}