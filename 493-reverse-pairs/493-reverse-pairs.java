class Solution {
    public int reversePairs(int[] nums) {
        // long[] arr = new long[nums.length];
        // for(int i = 0;i<nums.length;i++){
        //     arr[i] = nums[i]
        // }
        return mergeSort(0,nums.length-1,nums);
        
    }
    
    int mergeSort(int low,int high,int[] nums){
        if(low >= high){
            return 0;
        }
        int mid = (low + high)/2;
        int count = 0;
        count += mergeSort(low,mid,nums);
        count += mergeSort(mid+1,high,nums);
        count += merge(low,mid,high,nums);
        return count;
    }
    
    int merge(int low,int mid,int high,int[] nums){
        int i = low;
        int j = mid+1;
        int count = 0;
        for(i = low;i<= mid;i++){
            long first = nums[i];
            long sec = 0;
            if(j <= high){
                sec = nums[j];
            }
            sec = sec * 2;
            while(j <= high && first > sec){
                j++;
                sec = 0;
                if(j <= high){
                    sec = nums[j];
                    sec = sec * 2;
                }
            }
            count += j - (mid+1);
        }
        
        i = low;
        j = mid+1;
        int index = 0;
        int[] temp = new int[high - low + 1];
        while(i <= mid && j <= high ){
            if(nums[i] <= nums[j]){
                temp[index++] = nums[i++];
            }
            else {
                temp[index++] = nums[j++];
            }
        }
        
        while(i <= mid){
            temp[index++] = nums[i++];
        }
        while(j <= high){
            temp[index++] = nums[j++];
        }
        index = low;
        for(i = 0;i<temp.length;i++){
            nums[index++] = temp[i];
        }
        
        return count;
    }
}