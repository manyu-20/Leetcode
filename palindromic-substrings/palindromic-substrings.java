class Solution {
    static int[][] dp;
    public int countSubstrings(String s) {
        int len = s.length();
        dp = new int[len+1][len+1];
        for(int i= 0;i<=len;i++){
            Arrays.fill(dp[i],-1);
        }
        int count = 0;
        for(int i = 0;i<len;i++){
            for(int j = i;j<len;j++){
                if(isPalin(i,j,s) == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    int isPalin(int i,int j,String s){
        if(i>=j){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) != s.charAt(j)){
            return dp[i][j] = 0;
        }
        return dp[i][j] = isPalin(i+1,j-1,s);
    }
}