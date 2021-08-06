class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x : nums){
            hm.put(x,hm.getOrDefault(x,0) + 1);
        }
        for(int item : hm.keySet()){
            pq.add(new int[]{item,hm.get(item)});
            if(pq.size() > k){
                pq.remove();
            }
        }
        int index = 0;
        while(!pq.isEmpty()){
            ans[index] = pq.remove()[0];
            index++;
        }
        return ans;
        
        
    }
}