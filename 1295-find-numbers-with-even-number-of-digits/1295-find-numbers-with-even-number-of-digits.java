class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int x : nums){
            if(digits(x) % 2 ==0){
                count++;
            }
        }
        return count;
    }
    
    private int digits(int n){
        if(n <= 9)return 1;
        int count = 0;
        //123
        while(n > 0){
            n = n/10;
            count++;
        }
        return count;
    }
}