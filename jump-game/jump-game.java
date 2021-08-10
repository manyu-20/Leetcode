class Solution {
    public boolean canJump(int[] nums) {
        int l,r;
        l = r = 0;
        while(r < nums.length - 1){
            int max = 0;
            for(int i = l;i<=r;i++){
                max = Math.max(max,i + nums[i]);
            }
            l = r + 1;
            r = max;
            if(l > r){
                return false;
            }
        }
        return true;
    }
}