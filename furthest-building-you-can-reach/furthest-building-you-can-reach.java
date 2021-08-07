class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
        for(int i = 0;i<n-1;i++){
            int diff = heights[i+1] - heights[i];
            if(diff > 0){
                pq.add(diff);
                if(pq.size() > ladders){
                    int d = pq.remove();
                    if(bricks >= d ){
                        bricks = bricks - d;
                    }
                    else{
                        return i;
                    }
                }
            }
        }
        return n-1;
    }
}