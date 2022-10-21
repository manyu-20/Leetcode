class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        while(j < nums.length){
            while(j-i > k){
                hm.put(nums[i],hm.get(nums[i])-1);
                if(hm.get(nums[i]) == 0){
                    hm.remove(nums[i]);
                }
                i++;
            }
            if(hm.containsKey(nums[j])){
                return true;
            }
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            
            j++;
        }
        
        return false;
    }
}