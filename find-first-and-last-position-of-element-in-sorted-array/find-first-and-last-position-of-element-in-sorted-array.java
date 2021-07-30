class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = search(nums,target,true);
        arr[1] = search(nums,target,false);
        return arr;
    }
    
    private int search(int[] nums,int target,boolean leftb){
        int left = 0;
        int right = nums.length-1;
        int i = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                i = mid;
                if(leftb){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return i;
    }
}