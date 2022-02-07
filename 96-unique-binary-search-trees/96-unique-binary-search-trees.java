class Solution {
    int[] dp;
    public int numTrees(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return count(n);
    }
    
    int count(int num){
        if(num == 0){
            return 1;
        }
        if(num == 1){
            return 1;
        }
        if(dp[num] != -1){
            return dp[num];
        }
        int sum = 0;
        for(int i = 1;i<=num;i++){
            int left = i - 1;        
            int right = num - i;
            sum = sum + count(left) * count(right);
        }
        
        return dp[num] = sum;
        
    }
    

    
    
}