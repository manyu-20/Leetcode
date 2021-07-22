class Solution {
    public boolean isSubsequence(String s, String t) {
        return fun(s.toCharArray(),t.toCharArray(),0,0);
    }
    
    private boolean fun(char[] s,char[] t,int index1,int index2){
        if(index1 == s.length){
            return true;
        }
        if(index2 == t.length){
            return false;
        }
        if(s[index1] == t[index2]){
            return fun(s,t,index1+1,index2+1);
        }
        else{
            return fun(s,t,index1,index2+1);
        }
        
    }
}