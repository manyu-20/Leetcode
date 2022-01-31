class Solution {
    HashSet<ArrayList<Integer>> hs;
    List<List<Integer>> ls;
    public List<List<Integer>> subsets(int[] nums) {
        ls = new ArrayList<>();
        if(nums.length == 0){
            return ls;
        }
        List<Integer> arr = new ArrayList<>();
        hs = new HashSet<>();
        helper(0,nums,arr);
        for(List<Integer> x : hs){
            ls.add(new ArrayList<>(x));
        }
        return ls;
    }
    
    private void helper(int index,int[] nums,List<Integer> arr){
        if(index >= nums.length){
            hs.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[index]);
        helper(index+1,nums,arr);
        arr.remove(arr.size()-1);
        helper(index+1,nums,arr);
    }
}