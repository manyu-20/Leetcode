class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int x : digits){
            list.add(x);
        }
        
        int i = list.size()-1;
        int add = 1;
        while(i >= 0 && add > 0){
            int num = list.get(i) + add;
            add = num / 10;
            num = num % 10;
            list.set(i,num);
            i--;
        }
        
        if(add > 0){
            list.add(0,add);
        }
        int[] ans = new int[list.size()];
        
        for(int j = 0;j<list.size();j++){
            ans[j] = list.get(j);
        }
        
        return ans;
    }
}