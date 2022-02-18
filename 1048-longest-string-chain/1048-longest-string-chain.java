class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                String prev = words[j];
                String curr = words[i];
                
                if(curr.length() - prev.length() == 1 && fun(0,0,prev,curr)){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        
        return max;
    }
    
    boolean fun(int i,int j,String first,String sec){
        if(i == first.length()){
            return true;
        }
        if(j == sec.length()){
            return false;
        }
        
        if(first.charAt(i) == sec.charAt(j)){
            return fun(i+1,j+1,first,sec);
        }
        else{
            return fun(i,j+1,first,sec);
        }
    }
}