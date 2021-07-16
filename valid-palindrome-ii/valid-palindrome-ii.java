class Solution {
    public boolean validPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }
        int count = 0;
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i)!=s.charAt(j)){
                return fun(s.substring(0,i) + s.substring(i+1,s.length())) || fun(s.substring(0,j) + s.substring(j+1,s.length()));
            }
            i++;
            j--;
        }
        return true;
    }
    
    private boolean fun(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}