class Solution {
    public int minOperations(int[] nums, int x) {
        int i = 0;
        int j = 0;
        int sum = 0;
        for(int y : nums){
            sum = sum + y;
        }
        
        int find = sum - x;
        int n = nums.length;
        int total = 0;
        int max = Integer.MIN_VALUE;
        while(j < n){
            total = total + nums[j];
            if(total > find){
                while(total > find && i <= j){
                    total = total - nums[i];
                    i++;
                }
            }
            if(total == find){
               max = Math.max(max,j-i+1); 
            }
            j++;
        }
        
        if(max == Integer.MIN_VALUE){
            return -1;
        }
        return n - max;
    }
}