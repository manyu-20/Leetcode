class Solution {
    static int[] dp;
    public int deleteAndEarn(int[] nums) {
        
        int max = -1;
        for(int x : nums){
            max = Math.max(x,max);
        }
        int[] arr = new int[max+1];
        dp = new int[max + 1];
        Arrays.fill(dp,-1);
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]] = arr[nums[i]] + nums[i];
        }
        int index = 1;
        return fun(arr,index);
    }
    
    private int fun(int[] arr,int index){
        if(index >= arr.length){
            return 0;
        }
        if(arr[index] == 0){
            return fun(arr,index + 1);
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        
        //take it 
        int take = arr[index] + fun(arr,index+2);
        
        //leave it
        int leave = fun(arr,index + 1);
        
        return dp[index] =  Math.max(take,leave);
    }
}