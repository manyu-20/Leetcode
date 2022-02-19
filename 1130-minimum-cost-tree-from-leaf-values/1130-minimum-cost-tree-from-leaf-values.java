class Solution {
    int[][] dp;
    public int mctFromLeafValues(int[] arr) {
        
        int n = arr.length;
        dp = new int[n+1][n+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
            return fun(0,n-1,arr);
    }
    
    int fun(int i,int j,int[] arr){
        if( i>= j){
            return 0;
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int left = fun(i,k,arr);
            int right = fun(k+1,j,arr);
            
            int first = finMin(i,k,arr);
            int sec = finMin(k+1,j,arr);
            min = Math.min(min,left + right + (first * sec));
        }
        
        return dp[i][j] = min;
    }
    
    int finMin(int i,int j,int[] arr){
        int max = Integer.MIN_VALUE;
        for(int k = i;k<=j;k++){
            max = Math.max(max,arr[k]);
        }
        return max;
    }
}