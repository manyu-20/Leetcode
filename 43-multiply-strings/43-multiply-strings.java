class Solution {
    public String multiply(String num1, String num2) {
        
        if(num1.length() < num2.length()){
            return multiply(num2,num1);
        }
        
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0'){
            return "0";
        }
        
        LinkedList<StringBuilder> ll = new LinkedList<>();
        
        int carry = 0;
        
        
        int j = num2.length()-1; // small
        
        //multiply mechanism
        
        int zero = 0;
        while(j >= 0){
            StringBuilder sb = new StringBuilder("");
            for(int i = 1;i<=zero;i++){
                sb.insert(0,"0");
            }
            zero++;
            int i = num1.length()-1;
            int base = Character.getNumericValue(num2.charAt(j));
            while(i >= 0){
                int mul = Character.getNumericValue(num1.charAt(i));
                mul = (base * mul) + carry;
                carry = mul/10;
                mul = mul % 10;
                sb.insert(0,String.valueOf(mul));
                i--;
            }
            if(carry > 0){
                sb.insert(0,String.valueOf(carry));
            }
            carry = 0;
            ll.add(sb);
            j--;
        }
        
        while(ll.size()> 1){
            String first = ll.remove().toString();
            String sec = ll.remove().toString();
            StringBuilder input = fun(first,sec);
            ll.add(input);
        }
        
        return ll.remove().toString();
        
        
        
        
    }
    
    StringBuilder fun(String first,String sec){
        if(first.length() < sec.length()){
            return fun(sec,first);
        }
        
        StringBuilder sb = new StringBuilder("");
        int i = first.length()-1; //big
        int j = sec.length() - 1;  //small
        int carry = 0;
        while(i >= 0 || j >=0 ){
            int sum = 0;
            if(j >=  0){
                sum = Character.getNumericValue(sec.charAt(j));
                j--;
            }
            sum = sum + Character.getNumericValue(first.charAt(i)) + carry;
            carry = sum/10;
            sum = sum % 10;
            sb.insert(0,String.valueOf(sum));
            i--;
        }
        
        if(carry > 0){
            sb.insert(0,String.valueOf(carry));
        }
        
        return sb;
        
        
    }
}