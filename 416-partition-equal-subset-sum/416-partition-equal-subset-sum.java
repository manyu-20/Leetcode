class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums){
            sum = sum + x;
        }
        if(sum % 2 != 0){
            return false;
        }
        int find = sum/2;
        dp = new Boolean[nums.length + 1][find + 1];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],null);
        }
        return fun(0,find,nums);
    }
    
    boolean fun(int index,int find,int[] nums){
        if(find == 0){
            return true;
        }
        if(index >= nums.length || find < 0){
            return false;
        }
        
        if(dp[index][find] != null){
            return dp[index][find];
        }
        
        if(nums[index] <= find){
            return dp[index][find] = fun(index + 1,find - nums[index],nums) || fun(index+1,find,nums);
        }
        else{
            return dp[index][find] = fun(index + 1,find,nums);
        }
    }
}