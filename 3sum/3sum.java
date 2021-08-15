class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        List<List<Integer>> ans;
        HashSet<List<Integer>> list = new HashSet<>();
        for(int i = 0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            List<Integer> ll = new ArrayList<>();
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ll.add(nums[i]);
                    ll.add(nums[j]);
                    ll.add(nums[k]);
                    list.add(new ArrayList<>(ll));
                    ll = new ArrayList<>();
                }
                if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ans = new ArrayList<>(list);
    }
}