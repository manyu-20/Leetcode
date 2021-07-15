class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        fun(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }
    
    private void fun(int index,int[] nums,List<Integer> current, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(current));
        for(int i = index;i<nums.length;i++){
            current.add(nums[i]);
            fun(i + 1,nums,current,subsets);
            current.remove(current.size() - 1);
        }
    }
}