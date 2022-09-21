class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] % 2 == 0){
                sum = sum + nums[i];
                hm.put(i,nums[i]);
            }
        }
        int[] res = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int val = queries[i][0];
            int index = queries[i][1];
            int prev = nums[index];
            int next = nums[index] + val;
            if(prev % 2 == 0 && next % 2 == 0){
                // hm.put(index,next);
                // nums[index] = next;
                sum = sum + val;
            }
            else if(prev % 2 == 0){
                // hm.remove(index);
                sum = sum - prev;
            }
            else if(next % 2 == 0){
                // hm.put(index,next);
                // nums[index] = next;
                sum = sum + next;
            }
            nums[index] = next;
            res[i] = sum;
        }
        
        return res;
        
        
    }
}