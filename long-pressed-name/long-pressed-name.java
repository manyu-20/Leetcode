class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i,j;
        i = j = 0;
        int m = name.length();
        int n = typed.length();
        
        while(i < m && j < n){
            char c1 = name.charAt(i);
            char c2 = typed.charAt(j);
            if(c1 != c2){
                return false;
            }
            
            int count1 = 0;
            while(i < m && name.charAt(i) == c1){
                count1++;
                i++;
            }
            int count2 = 0;
            while(j < n && typed.charAt(j) == c2 ){
                count2++;
                j++;
            }
            if(count2 < count1){
                return false;
            }
        }
        
        return i == m && j == n;
    }
}