class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int len = nums.length;
        int start = 0;
        int end = 0;
        int temp = k;
        int zeroCount = 0 ;
        for(end = 0;end < len;end++){
            if(nums[end] == 0){
                zeroCount++;
            }
            if(zeroCount > k){
                while(zeroCount > k){
                    if(nums[start] == 0){
                        zeroCount--;
                    }
                    start++;
                }
            }
            max = Math.max(max,end - start  + 1);
        }
        return max;
        
    }
}