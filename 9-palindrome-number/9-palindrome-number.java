class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        return helper(num,0,num.length()-1);
    }
    
    private boolean helper(String num,int start,int end){
        if(start >= end){
            return true;
        }
        
        if(num.charAt(start) == num.charAt(end)){
            return helper(num,start+1,end-1);
        }
        return false;
    }
}