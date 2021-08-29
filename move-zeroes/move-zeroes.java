class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int vacant = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[vacant] = nums[i];
                vacant++;
            }
            else{
                count++;
            }
        }
        
        for(int i = nums.length - count;i<nums.length;i++){
            nums[i] = 0;
        }
        
    }
}