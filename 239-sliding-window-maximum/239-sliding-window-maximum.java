class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        Deque<Integer> dq = new LinkedList<>();
         
        int i = 0;
        int j = 0;
        int n = nums.length;
        while(j < n){
            while(dq.size() > 0 && dq.peekLast() < nums[j]){
                dq.removeLast();
            }
            dq.addLast(nums[j]);
            
            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                arr.add(dq.peekFirst());
                if(dq.peekFirst() == nums[i]){
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
        
        int[] res = new int[arr.size()];
        
        for(int p = 0;p<arr.size();p++){
            res[p] = arr.get(p);
        }
        
        return res;
    }
}