class Solution {
    public int findMin(int[] arr) {
        int res = arr[0];
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            if(arr[start] < arr[end]){
                res = Math.min(res,arr[start]);
            }
            int mid = (start + end)/2;
            res = Math.min(arr[mid],res);
            if(arr[mid] >= arr[start]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return res;
    }
}