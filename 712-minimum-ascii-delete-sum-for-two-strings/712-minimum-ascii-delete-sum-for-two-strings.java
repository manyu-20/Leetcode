class Solution {
    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0;i<=s1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(s1,s2,s1.length(),s2.length());
    }
    
    int fun(String s1,String s2,int n1,int n2){
        if(n1 == 0 && n2 == 0){
            return 0;
        }
        if(n1 == 0){
            int sum = 0;
            for(int i = n2-1;i>=0;i--){
                sum = sum + (int)s2.charAt(i);
            }
            return sum;
        }
        if(n2 == 0){
            int sum = 0;
            for(int i = n1-1;i>=0;i--){
                sum = sum + (int)s1.charAt(i);
            }
            return sum;
        }
        
        if(dp[n1][n2] != -1){
            return dp[n1][n2];
        }
        
        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            return dp[n1][n2] = fun(s1,s2,n1-1,n2-1);
        }
        else{
            int first = (int)s1.charAt(n1-1) + fun(s1,s2,n1-1,n2);
            int second = (int)s2.charAt(n2-1) + fun(s1,s2,n1,n2-1);
            return dp[n1][n2] = Math.min(first,second);
        }
    }
}