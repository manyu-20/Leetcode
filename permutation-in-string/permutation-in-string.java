class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0 || s2.length() < s1.length()){
            return false;
        }
        int[] arr = new int[26];
        
        for(int i = 0;i<s1.length();i++){
            arr[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        int count = s1.length();
        while(right < s2.length()){
            if(arr[s2.charAt(right++) - 'a']-- >= 1){
                count--;
            }
            if(count == 0){
                return true;
            }
            if(right - left == s1.length() && arr[s2.charAt(left++) - 'a']++ >=0){
                count++;
            }
        }
        return false;
        
    }
}