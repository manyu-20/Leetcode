class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            List<Integer> put = new ArrayList<>();
            put.add(nums[i]);
            list.add(new ArrayList<>(put));
        }
        
        
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] % nums[j] == 0){
                    if(list.get(j).size()+1 > list.get(i).size()){
                        List<Integer> temp = new ArrayList<>(list.get(j));
                        temp.add(nums[i]);
                        list.set(i,temp);
                    }
                }
            }
        }
        
        int max = 1;
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            if(max <= list.get(i).size()){
                max = list.get(i).size();
                res = new ArrayList<>(list.get(i));
            }
        }
        
        return res;
    }
                       
                       
}