class Solution {
    public boolean canJump(int[] nums) {
        
        int max = nums[0];
        int steps = nums[0];
        int n = nums.length;
        
        if(n <= 1){
            return true;
        }
        
        if(nums[0] == 0) return false;
        
        for(int i = 1;i<n;i++){
            if(i == n-1){
                return true;
            }
            steps--;
            max = Math.max(max,i+nums[i]);
            
            if(steps == 0){
                if(i >= max){
                    return false;
                }
                else steps = max - i;
            }
        }
        return true;
    }
}