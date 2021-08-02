class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res = -1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums1.length;i++){
            hm.put(nums1[i],i);
        }
        Stack<Integer> main = new Stack<>();
        for(int x : nums2){
            main.push(x);
        }
        Stack<Integer> temp = new Stack<>();
        int[] ans = new int[nums1.length];
        for(int x : hm.keySet()){
            int index = hm.get(x);
            int max =  -1;
            while(!main.isEmpty()){
                if(main.peek() == x){
                    break;
                }
                int pop = main.pop();
                temp.push(pop);
                if(pop > x){
                    max = pop;
                }
            }
             ans[index] = max;
            while(!temp.isEmpty()){
                main.push(temp.pop());
            }
        }
        return ans;
        
    }
}