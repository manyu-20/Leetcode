class Solution {
    public int findMaxLength(int[] nums) {
        
        int max = 0;
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                sum = sum - 1;
            }
            else{
                sum = sum + 1;
            }
            
            if(hm.containsKey(sum)){
                max = Math.max(max,i - hm.get(sum));
            }
            else{
                hm.put(sum,i);
            }
        }
        return max;
    }
}