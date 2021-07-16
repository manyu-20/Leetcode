class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i = 0;
        int j = 0;
        int len = s.length();
        if(len == 0){
            return 0;
        }
        HashSet<Character> hs = new HashSet<>();
        int max = 1;
        while(i < len && j < len){
            char c = s.charAt(j);
            if(hs.contains(c)){
                hs.remove(s.charAt(i));
                i++;
            }
            else{
                max = Math.max(max,j - i + 1);
                hs.add(c);
                j++;
            }
        }
        return max;
    }
}