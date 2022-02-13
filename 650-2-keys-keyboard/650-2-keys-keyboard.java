class Solution {
    public int minSteps(int n) {
        return fun(1,n,0,0);
    }
    
    int fun(int start,int n,int copy,int count){
        if(start == n){
            return 0;
        }
        if(start > n){
            return 1001;
        }
        
        if(copy == 1){
            int first = 1 + fun(start + count,n,1,count);
            int sec = 1 + fun(start + count,n,0,count);
            return Math.min(first,sec);
        }
        else{
            return 1 + fun(start,n,1,start);
        }
    }
}