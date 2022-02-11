class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums){
            sum = sum + x;
        }
        if(sum % 2 != 0){
            return false;
        }
        int find = sum/2;
        
        int n = nums.length;
        Boolean[][] dp = new Boolean[n+1][find+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],null);
        }
        
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=find;j++){
                if(i == 0){
                    dp[i][j] = false;
                }
                if(j == 0){
                    dp[i][j] = true;
                }
            }
        }
        
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=find;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][find];
        
        
    }
    
    boolean fun(int[] nums,int n,int find){
        if(find == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        
        if(nums[n-1] <= find ){
            return fun(nums,n-1,find - nums[n-1]) || fun(nums,n-1,find);
        }
        
        else{
            return fun(nums,n-1,find);
        }
    }
    

}