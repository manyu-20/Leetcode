class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        
        int n = nums1.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int sum = nums1[i] + nums2[j];
                hm.put(sum,hm.getOrDefault(sum,0)+1);
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int sum = -1 * (nums3[i] + nums4[j]);
                if(hm.containsKey(sum)){
                    count = count + hm.get(sum);
                }
            }
        }
        
        
        
        return count;
    }
}