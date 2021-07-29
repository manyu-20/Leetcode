class Solution {
    static HashMap<Integer,Integer> hm;
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        hm = new HashMap<>();
        int n = stones.length;
        for(int i = 0;i<stones.length;i++){
            hm.put(stones[i],i);
        }
        dp = new Boolean[n+1][n+1];
        int pos = 0;
        int speed = 0;
        return fun(stones,n,pos,speed);
    }
    
    private boolean fun(int[] stones,int n,int pos,int speed){
        if(pos == n-1){
            return true;
        }
        if(dp[pos][speed] != null){
            return dp[pos][speed];
        }
        boolean local = false;
        Integer slow = hm.get(stones[pos] + (speed - 1));
        Integer same = hm.get(stones[pos] + (speed));
        Integer fast = hm.get(stones[pos] + (speed + 1));
        
        if(slow != null && speed - 1 > 0){
            local = local || fun(stones,n,slow,speed - 1);
        }
        if(same != null && speed > 0){
            local = local || fun(stones,n,same,speed);
        }
        if(fast != null && speed + 1 > 0){
            local  = local || fun(stones,n,fast,speed + 1);
        }
        return dp[pos][speed] =  local;
    }
    
    
}