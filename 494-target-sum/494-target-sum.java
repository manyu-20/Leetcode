class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> hm;
    public int findTargetSumWays(int[] nums, int target) {
        hm = new HashMap<>();
        return fun(0,nums,target);
    }
    
    int fun(int index,int[] nums,int target){
        if(index >= nums.length){
            if(target == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(hm.containsKey(index) && hm.get(index).containsKey(target)){
            return hm.get(index).get(target);
        }
        int res = fun(index+1,nums,target + nums[index]) + fun(index+1,nums,target-nums[index]);
        hm.putIfAbsent(index,new HashMap<>());
        hm.get(index).put(target,res);
        return hm.get(index).get(target);
        
        
    }
}