class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] temp = new int[101];
        
        for(int x : nums){
            temp[x]++;
        }
        
        for(int i = 1;i<=100;i++){
            temp[i] = temp[i-1] + temp[i];
        }
        
        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                ans[i] = 0;
            }
            else ans[i] = temp[nums[i]-1];
        }
        return ans;
    }
}