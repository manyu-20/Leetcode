class Solution {
    public int singleNumber(int[] nums) {
        int base = 30000;
        int[] arr = new int[(2 * base) + 1];
        
        for(int i = 0;i<nums.length;i++){
            arr[base + nums[i]]++;
        }
        int i;
        for(i = 0;i<arr.length;i++){
            if(arr[i] == 1){
                break;
            }
        }
        return i - base;
    }
}