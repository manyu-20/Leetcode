class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int ite = 0;
        for(int i = 0;i<n;i++){
            ans[ite] = nums[i];
            ite = ite + 2;
        }
        ite = 1;
        for(int i = n;i<2*n;i++){
            ans[ite] = nums[i];
            ite = ite + 2;
        }
        return ans;
    }
}