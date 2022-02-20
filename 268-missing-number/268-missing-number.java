class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int total = 0;
        for(int i = 0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        
        for(int i = 0;i <= n;i++){
            total = total + i;
        }
        
        return total - sum;
        
        
    }
}