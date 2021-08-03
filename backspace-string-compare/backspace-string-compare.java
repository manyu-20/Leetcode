class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> first = new Stack<>();
        Stack<Character> second = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '#'){
                if(!first.isEmpty()){
                first.pop();
                }
            }
            else{
                first.push(c);
            }
        }
        
        for(char c : t.toCharArray()){
            if(c == '#'){
                if(!second.isEmpty()){
                second.pop();
            }
            }
            else second.push(c);
        }
        
        while(!first.isEmpty() && !second.isEmpty()){
            if(first.pop() != second.pop()){
                return false;
            }
        }
        
        if(first.isEmpty() && second.isEmpty()){
            return true;
        }
        return false;
    }
}