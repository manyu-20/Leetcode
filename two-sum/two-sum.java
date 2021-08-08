class Solution {
    static class pair{
        int x,y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        pair[] p = new pair[nums.length];
        for(int i = 0;i<nums.length;i++){
            p[i] = new pair(nums[i],i);
        }
        Arrays.sort(p,(a,b) -> a.x - b.x);
        int res = -1;
        for(int i = 0;i<p.length;i++){
            int find =  target - p[i].x;
            int val = binarySearch(i+1,p.length -1,p,find);
            if(val != -1){
                return new int[]{p[i].y,val};
            }
        }
        return new int[]{-1,-1};
    }
    
    int binarySearch(int start,int end,pair[] arr,int key){
        if(start > end){
            return -1;
        }
        int mid = start + ((end - start)/2);
        if(arr[mid].x == key){
            return arr[mid].y;
        }
        else if(arr[mid].x < key){
            return binarySearch(mid + 1,end,arr,key);
        }
        else{
            return binarySearch(start,mid - 1,arr,key);
        }
    }
}