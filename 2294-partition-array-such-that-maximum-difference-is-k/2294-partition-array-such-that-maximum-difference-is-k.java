class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        
        int start = 0;
        
        int buckets = 1;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i] - nums[start] <= k){
                continue;
            }
            buckets++;
            start = i;
        }
        
        return buckets;
    }
}