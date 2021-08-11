class Solution {
    public String smallestSubsequence(String s) {
        
        int len = s.length();
        
        if(len == 1){
            return s;
        }
        int[] freq = new int[26];
        boolean[] present = new boolean[26];
        
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        
        Stack<Character> st = new Stack<>();
        
        for(int i= 0;i<len;i++){
            char c = s.charAt(i);
            freq[c - 'a']--;
            if(present[c - 'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek() > c && freq[st.peek() - 'a'] > 0){
                present[st.pop() - 'a'] = false;
            }
            st.push(c);
            present[c - 'a'] = true;
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}