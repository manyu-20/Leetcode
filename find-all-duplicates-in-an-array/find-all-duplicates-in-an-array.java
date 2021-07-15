class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                ll.add(index+1);
            }
            nums[index] = -1 * nums[index];
            
        }
        return ll;
    }
}