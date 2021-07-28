class Solution {
    static int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<word1.length()+1;i++){
             Arrays.fill(dp[i],-1);
        }
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        return fun(sb1,sb2,word1.length()-1,word2.length()-1);
    }
    
    private int fun(StringBuilder word1,StringBuilder word2,int index1,int index2){
        if(index1 < 0){
           return index2 + 1;
        }
        if(index2 < 0){
            return index1 + 1;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(word1.charAt(index1) == word2.charAt(index2)){
            return fun(word1,word2,index1-1,index2-1);
        }
        // insert
        int insert = 1 + fun(word1,word2,index1,index2-1);
        //delete
        int delete = 1 + fun(word1,word2,index1-1,index2);
        //replace
        int replace = 1 + fun(word1,word2,index1-1,index2-1);
        int min = Integer.MAX_VALUE;
        min = Math.min(delete,insert);
        return dp[index1][index2] =  Math.min(min,replace);

    }
}