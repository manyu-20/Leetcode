class Solution {
    public int[] nextGreaterElements(int[] nums) {
       Stack<Integer> s = new Stack<>();
        int len = nums.length;
        for(int i = len-1;i>=0;i--){
            s.push(nums[i]);
        }
        
        int[] ans = new int[len];
        
        for(int i = len-1;i>=0;i--){
            int ele = nums[i];
            while(!s.isEmpty() && s.peek() <= ele){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = s.peek();
            }
            s.push(ele);
        }
        return ans;
    }
}