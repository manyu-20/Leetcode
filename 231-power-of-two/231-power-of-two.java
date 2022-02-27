class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        int count = 0;
        
        for(int i = 0;i<=31;i++){
            int ele = (n >> i) & 1;
            if(ele == 1){
                count++;
            }
        }
        
        if(count == 1){
            return true;
        }
        else{
            return false;
        }
    }
}