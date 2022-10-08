class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 100000;
        int minGap = 100000;
        int len = nums.length;
        for(int i = 0;i<len;i++){
            int sum = nums[i];
            int j = i+1;
            int k = len - 1;
            while(j < k){
                sum = sum + nums[j] + nums[k];
                if(Math.abs(target - sum) < minGap){
                    minGap = Math.abs(target - sum);
                    min = sum;
                }
                if(sum > target){
                    sum = sum - (nums[k] + nums[j]);
                    k--;
                    
                }
                else if(sum < target){
                    sum = sum - (nums[k] + nums[j]);
                    j++;
                }
                else{
                    return target;
                }
            }
        }
        return min;
    }
}