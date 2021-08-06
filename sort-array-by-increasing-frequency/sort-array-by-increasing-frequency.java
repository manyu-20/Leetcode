class Solution {
    public int[] frequencySort(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] ans = new int[nums.length];
        for(int item : nums){
            hm.put(item,hm.getOrDefault(item,0) + 1);
        }
        for(int item : hm.keySet()){
            pq.add(new int[]{item,hm.get(item)});
        }
        int index = 0;
        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            int num = arr[0];
            int freq = arr[1];
            while(freq > 0){
                ans[index] = num;
                freq--;
                index++;
                }
        }
        return ans;
            
    }
}