class Solution {
    
    public int calculate(String s) {
        return eval(s, 0, s.length() - 1);
    }
    
    private int eval(String s, int start, int end) {
        for (int i = end; i >= start; i--) {
            char c = s.charAt(i);
            if (c == '+') {
                return eval(s, start, i - 1) + eval(s, i + 1, end);
            } else if (c == '-') {
                return eval(s, start, i - 1) - eval(s, i + 1, end);
            }
        }
        
        for (int i = end; i >= start; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                return eval(s, start, i - 1) * eval(s, i + 1, end);
            } else if (c == '/') {
                return eval(s, start, i - 1) / eval(s, i + 1, end);
            }
        }
        
		// skip whitespace
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        return Integer.parseInt(s.substring(start, end + 1));
    }
}