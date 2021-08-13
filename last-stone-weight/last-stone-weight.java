class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int x : stones){
            pq.add(x);
        }
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                return pq.remove();
            }
            else{
                int x = pq.remove();
                int y = pq.remove();
                if(x - y >0){
                    pq.add(x-y);
                }
            }
        }
        return 0;
    }
}