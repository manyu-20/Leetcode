class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
      List<Integer> list = new ArrayList<>();
        int n = num.length;
        
        for(int i = n-1;i>=0;i--){
            int number = num[i];
            int sum = number + k;
            int rem = sum % 10;
            list.add(0,rem);
            k = sum/10;
        }
        
        while(k > 0){
            list.add(0,k%10);
            k = k/10;
        }
        return list;
    }
}