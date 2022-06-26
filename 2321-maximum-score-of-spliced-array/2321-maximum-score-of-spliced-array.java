class Solution {
    int[][] dp;
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        dp = new int[nums1.length+1][4];
        for(int i = 0;i<nums1.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int first = fun(0,1,nums1,nums2);
        dp = new int[nums1.length+1][4];
        for(int i = 0;i<nums1.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int sec = fun(0,1,nums2,nums1);
        return Math.max(first,sec);
    }
    
    int fun(int index,int take,int[] nums1,int[] nums2){
        if(index == nums1.length){
            dp[index][take+1] = 0;
            return 0;
        }
        if(dp[index][take+1] != -1){
            return dp[index][take+1];
        }
        if(take == 1){
            int first = nums2[index] + fun(index+1,0,nums1,nums2);
            int sec = nums1[index] + fun(index+1,1,nums1,nums2);
            int third = nums1[index] + fun(index + 1,0,nums1,nums2);
            int val =   Math.max(first,Math.max(sec,third));
            dp[index][take+1] = val;
            return val;
        }
        
        if(take == 0){
            int first = nums2[index] + fun(index + 1,0,nums1,nums2);
            int sec = nums2[index] + fun(index + 1,-1,nums1,nums2);
            int third = nums1[index] + fun(index+1,-1,nums1,nums2);
            int val =   Math.max(first,Math.max(sec,third));
            dp[index][take+1] = val;
            return val;
        }
        
        else {
            int val =  nums1[index] + fun(index+1,-1,nums1,nums2);
            dp[index][take+1] = val;
            return val;
        }
        
    }
}