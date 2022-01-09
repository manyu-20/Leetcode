class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        //reverse the array
        fun(nums,0,n-1);
        fun(nums,0,k-1);
        fun(nums,k,n-1);
    }
    
    private void fun(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}