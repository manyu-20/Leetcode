class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> stack = new Stack<>();
        int len = num.length();
        if(k==len)        
            return "0";
        for(int i = 0;i<len;i++){
            char n = num.charAt(i);
            while(k > 0 && !stack.isEmpty() && stack.peek() > n ){
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}