class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder("");
        int i = n-1;
        
        while(i >= 0){
            if(Character.isDigit(s.charAt(i))){
                StringBuilder no = new StringBuilder("");
                while(i >=0 && Character.isDigit(s.charAt(i)) ){
                    no.append(s.charAt(i));
                    i--;   
                }
                i++;
                no.reverse();
                int num = Integer.parseInt(no.toString());
                System.out.println("num " + num);
                st.pop();
                StringBuilder temp = new StringBuilder("");
                while(!st.isEmpty() && !st.peek().equals("]")) {
                    temp.append(st.pop());
                }
                st.pop();
                StringBuilder rep = new StringBuilder("");
                
                for(int j = 0;j<num;j++){
                    rep.append(temp.toString());
                }
                st.push(rep.toString());
            }
            else st.push(String.valueOf(s.charAt(i)));
            
            i--;
        }
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}