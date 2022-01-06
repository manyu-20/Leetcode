class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x : nums){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int ans = 0;
        for (int x : hm.keySet()){
            int get = hm.get(x);
            ans = ans + ((get * (get-1))/2);
        }
        return ans;
    }
}