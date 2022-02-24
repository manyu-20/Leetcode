class Solution {
    public int longestSubarray(int[] nums) {
        
        int i = 0;
        int j = 0;
        int n = nums.length;
        int ans = 0;
        int k = 1;
        int count = 0;
        
        // for(int x : nums){
        //     if(x == 0){
        //         count++;
        //     }
        // }
        
        // if(count == 0){
        //     return n-1;
        // }
        // else count = 0;
        
        while(j < n){
            if(nums[j] == 0){
                count++;
            }

            if(count <= k){
                ans = Math.max(ans,j-i);
                j++;
            }
            else if(count > k){
                while(count > k){
                    if(nums[i] == 0){
                        count--;
                    }
                    i++;
                }
                j++;
            }
        }
        
        return ans;
    }
}