class Solution {
    static List<List<Integer>> list;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = i+1;
        }
        fun(nums,arr,n,k,0);
        return list;
        
    }
    
    void fun(int[] nums,ArrayList<Integer> arr,int n,int k,int index){
        if(k == 0){
            list.add(new ArrayList<>(arr));
            return;
        }
        if(index == n){
            return;
        }
        for(int i = index;i<n;i++){
            arr.add(nums[i]);
            fun(nums,arr,n,k-1,i+1);
            arr.remove(arr.size()-1);
            // fun(nums,arr,n,k,i+1);
        }
    }
}