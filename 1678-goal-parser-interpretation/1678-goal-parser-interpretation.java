class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder("");
        
        int i = 0;
        
        int n = command.length();
        
        while(i<n){
            char c = command.charAt(i);
            if(c == 'G'){
                sb.append("G");;
            }
            else if(c == '('){
                int count = 0;
                while(i<n && command.charAt(i) != ')'){
                    count++;
                    i++;
                }
                if(count == 1)sb.append("o");
                else sb.append("al");
            }
            i++;
        }
        return sb.toString();
    }
}