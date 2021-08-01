class Solution {
    public int findPeakElement(int[] arr) {
        int len = arr.length;
        int start = 0;
        int end = len - 1;
        int res = -1;
        while(start <= end){
            int mid = start + ((end - start)/2);
            boolean left,right;
            left = right = true;
            if(mid -1 >= 0 && arr[mid-1] > arr[mid]){
                left = false;
            }
            if(mid + 1 < len && arr[mid+1] > arr[mid]){
                right = false;
            }
            if(left && right){
                res = mid;
                break;
            }
            else{
                if(mid - 1 >= 0 && arr[mid - 1] > arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return res;
    }
}