class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        
        int i = 0;
        int j = sb.length()-1;
        
        while(i < j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}