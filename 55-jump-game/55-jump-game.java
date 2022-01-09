class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        if(n == 1){
            return true;
        }
        if(nums[0] == 0){
            return false;
        }
        
        int steps = nums[0];
        int max = nums[0];
        int jump = 0;
        
        for(int i = 1;i<n;i++){
            steps--;
            max = Math.max(max,nums[i]+i);
            
            if(max >= n-1){
                return true;
            }
            
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