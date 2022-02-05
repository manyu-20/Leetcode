class Solution {
    public int[] twoSum(int[] num, int target) {
        int n = num.length;
        int i = 0;
        int j = n-1;
        while(i < j){
            int sum = num[i] + num[j];
            if(sum == target){
                return new int[]{i+1,j+1};
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        
        return new int[]{-1,-1};
    }
}