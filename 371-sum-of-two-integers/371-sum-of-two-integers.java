class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int res = 0;
        int ans = 0;
        for(int i = 0;i<=31;i++){
            int first = (a >> i) & 1;
            int sec = (b >> i) & 1;
            
            res = (first ^ sec ^ carry);
            if(res == 0){
                a = a & ~(1 << i);
            }
            else if(res == 1){
                a = a | (1 << i);
            }
            int ones = 0;
            if(first == 1)ones++;
            if(sec == 1)ones++;
            if(carry == 1)ones++;
            
            if(ones >= 2){
                carry = 1;
            }
            else{
                carry = 0;
            }
            
        }
        return a;
    }
}