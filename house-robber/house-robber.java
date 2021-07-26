class Solution {
    static int[] dp;
    public int rob(int[] nums) {
        if(nums.length <= 1){
            return nums[0];
        }
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        int index = 0 ;
        return fun(nums,index);
    }
    
    private int fun(int[] nums,int index){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index]!= -1){
            return dp[index];
        }
        
        int first = nums[index] + fun(nums,index+2);
        int second = fun(nums,index+1);
        return dp[index] = Math.max(first,second);
    }
}