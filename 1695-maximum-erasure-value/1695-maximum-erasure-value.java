class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        int n = nums.length;
        int i = 0;
        int j = 0;
        
        while(j < n){
            if(hm.containsKey(nums[j])){
                hm.put(nums[j],2);
                while(hm.get(nums[j]) > 1){
                    if(hm.containsKey(nums[i])){
                        hm.put(nums[i],hm.get(nums[i])-1);
                    }
                    sum = sum - nums[i];
                    if(hm.get(nums[i]) == 0){
                        hm.remove(nums[i]);   
                    }
                    i++;
                }
                sum = sum + nums[j];
            }
            else{
                hm.put(nums[j],1);
                sum = sum + nums[j];
                max = Math.max(max,sum);
            }
            j++;
        }
        
        max = Math.max(max,sum);
        
        return max;
    }
}