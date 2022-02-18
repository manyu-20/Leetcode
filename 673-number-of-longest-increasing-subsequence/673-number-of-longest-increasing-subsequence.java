class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        count[0] = 1;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max = 1;
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    int prev = dp[j];
                    prev = prev + 1;
                    if(prev > dp[i]){
                        dp[i] = prev;
                        count[i] = count[j];
                    }
                    else if(prev == dp[i]){
                        count[i] = count[i] + count[j];
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        
        
        if(max == 1){
            return n;
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(dp[i] == max){
                ans = ans + count[i];
            }
        }
        
        return ans;
        
    }
}