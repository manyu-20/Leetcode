class Solution {
    public int minCost(String s, int[] cost) {
        int sum = 0;
        int max = 0;
        int res = 0;
        for(int i = 0;i<s.length();i++){
            if(i > 0 && s.charAt(i - 1) != s.charAt(i)){
                res = res + (sum - max);
                sum = 0;
                max = 0;
            }
            sum = sum + cost[i];
            max = Math.max(max,cost[i]);
        }
        res = res + (sum - max);
        return res;
    }
}