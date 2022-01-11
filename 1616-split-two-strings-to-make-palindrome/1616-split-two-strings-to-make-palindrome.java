class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
              
        
            return fun(a,b) || fun(b,a);
                            
                            
    }
    
    private boolean fun(String a, String b){
        int l = 0;
        int r = a.length()-1;
        while(l<r){
            if(a.charAt(l) != b.charAt(r)){
                break;
            }
            l++;
            r--;
        }
        
        return isPal(b,l,r) || isPal(a,l,r);
        
    }
    
    private boolean isPal(String x,int l,int r){
        while(l<r){
            if(x.charAt(l)!=x.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
        
    }
}