class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int start = 0;
        int max_count = 0;
        int len = s.length();
        int res = 0;
        for(int end = 0;end<len;end++){
            charCount[s.charAt(end) - 'A']++;
            max_count = Math.max(max_count,charCount[s.charAt(end) - 'A']);
            while(end - start + 1 - max_count >k){
                charCount[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res,end - start + 1);
        }
        return res;
    }
}