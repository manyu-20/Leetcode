class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums2.length;i++){
            int ele = nums2[i];
            while(!st.isEmpty() && st.peek() < ele){
                int popped = st.pop();
                hm.put(popped,ele);
            }
            st.push(ele);
        }
        int res[] = new int[nums1.length];
        int index = 0;
        for(int item : nums1){
            res[index] = hm.getOrDefault(item,-1);
            index++;
        }
        return res;
    }
}