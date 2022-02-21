class Solution {
    public boolean isPowerOfThree(int n) {
        return fun(n);
    }
    
    boolean fun(int n){
        if(n == 1){
            return true;
        }
        if(n == 0){
            return false;
        }
        if(n % 3 != 0){
            return false;
        }
        
        return fun(n/3);
    }
}