class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int min = Integer.MIN_VALUE;
        int len = weights.length;
        int res = -1;
        for(int x:weights){
            sum = sum + x;
            min = Math.max(min,x);
        }
        
        while(min <= sum){
            int mid = min + ((sum - min)/2);
            if(take(weights,mid,days)){
                res = mid;
                sum = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        return res;
    }
    
    boolean take(int[] arr,int capacity,int days){
        int sum = 0;
        int count = 1;
        for(int i = 0;i<arr.length;i++){
            if(sum + arr[i] > capacity){
                sum = 0;
                count++;
            }
                sum = sum + arr[i];
        }
        if(count > days){
            return false;
        }
        return true;
    }
}