class Solution {
    static List<List<Integer>> list;
    static HashSet<List<Integer>> hs;
    public List<List<Integer>> permuteUnique(int[] nums) {
        hs = new HashSet<>();
        list = new ArrayList<>();
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        if(n == 1){
            arr.add(nums[0]);
            list.add(new ArrayList<>(arr));
            return list;
        }
        int index = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0;i<n;i++){
            Arrays.fill(vis,false);
            arr.add(nums[i]);
            vis[i] = true;
            fun(nums,n,arr,i,vis);
            arr.remove(arr.size()-1);
        }
        for(List<Integer> l:hs){
            list.add(new ArrayList<>(l));
        }
        return list;
    }
    
    void fun(int[] nums,int n,ArrayList<Integer> arr,int index,boolean[] vis){
        if(arr.size() == n){
            hs.add(new ArrayList<>(arr));
            return;
        }
        // if(index == n){
        //     return;
        // }
        for(int i = 0;i<n;i++){
            if(i != index && !vis[i]){
                vis[i] = true;
                arr.add(nums[i]);
                fun(nums,n,arr,i,vis);
                arr.remove(arr.size()-1);
                vis[i] = false;
            }
        }
    }
}