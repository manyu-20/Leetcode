public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return fun(n);
    }
    
    int fun(int n){
        int count = 0;
        for(int i = 31;i>=0;i--){
            count = count + ((n >> i) & 1);
        }
        
        return count;
    }
}