class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        
        while(mid <= high){
            if(nums[mid] == 2){
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[low];
                nums[low] = 0;
                nums[mid] = temp;
                low++;
                mid++;
            }
        }
        
        
        
    }
}