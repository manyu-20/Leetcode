class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i = 0;i<n;i++){
            int res = search(i+1,n-1,numbers,target - numbers[i]);
            if(res != -1){
                return new int[]{i+1,res+1};
            }
        }
        return new int[]{-1,-1};
    }
    
    private int search(int low,int high,int[] ans,int target){
        if(low > high){
            return -1;
        }
        int mid = (low + high)/2;
        if(ans[mid] == target){
            return mid;
        }
        else if(target < ans[mid]){
            return search(low,mid-1,ans,target);
        }
        else{
            return search(mid+1,high,ans,target);
        }
    }
}