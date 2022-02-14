class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[201][201];
        for(int i = 0;i<=200;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,0,triangle);
        
    }
    
    int fun(int i,int level,List<List<Integer>> triangle){
        if(i < 0 || i >= triangle.get(level).size()){
            return Integer.MAX_VALUE;
        }
        if(level == triangle.size()-1){
            return triangle.get(level).get(i);
        }
        
        if(dp[i][level] != -1){
            return dp[i][level];
        }
        int down = fun(i,level+1,triangle);
        int right = fun(i+1,level+1,triangle);
        
        int min = triangle.get(level).get(i) + Math.min(down,right);
        
        return dp[i][level] = min;
    }
}