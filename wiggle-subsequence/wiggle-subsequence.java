class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return 1;
        }
        Stack<Integer> st = new Stack<>();
        int max = 1;
        for(int i = 1;i<n;i++){
            int sec = nums[i];
            int fir = nums[i-1];
            int diff = sec - fir;
            boolean positive = true;
            if(diff < 0)positive = false;
            if(diff == 0){
                continue;
            }
            if(!st.isEmpty() && !is(st.peek(),positive)){
                st.pop();
            }
            st.push(diff);
            max = Math.max(max,st.size()+1);
        }
        
        return Math.max(max,st.size() + 1);
        
        
    }
    
    boolean is(int num,boolean positive){
        if(num == 0){
            return false;
        }
            
        if(positive){

            return num < 0;
        }
        else{
            return num > 0;
        }
    }
}