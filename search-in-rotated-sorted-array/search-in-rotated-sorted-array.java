class Solution {
    public int search(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + ((end - start)/2);
            if(arr[mid] == target){
                res = mid;
                break;
            }
            else if(arr[mid] >= arr[start]){
                if(target <= arr[mid] && target >= arr[start]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(target >= arr[mid] && target <= arr[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return res;
    }
}