class Solution {
    static List<String> list;
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if(digits.length() == 0){
            return list;
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        fun(digits,index,sb);
        return list;
    }
    void fun(String digits,int index,StringBuilder sb){
        if(sb.length() == digits.length()){
            list.add(sb.toString());
        }
        if(index >= digits.length()){
            return;
        }
        char c = digits.charAt(index);
        if(c == '2'){
            fun2("abc",sb,digits,index);
        }
        if(c == '3'){
            fun2("def",sb,digits,index);
        }
        if(c == '4'){
            fun2("ghi",sb,digits,index);
        }
        if(c == '5'){
            fun2("jkl",sb,digits,index);
        }
        if(c == '6'){
            fun2("mno",sb,digits,index);
        }
        if(c == '7'){
            fun2("pqrs",sb,digits,index);
        }
        if(c == '8'){
            fun2("tuv",sb,digits,index);
        }
        if(c == '9'){
            fun2("wxyz",sb,digits,index);
        }
        
    }
    
    void fun2(String temp,StringBuilder sb,String digits,int index){
        int len = sb.length();
         for(int i =0;i<temp.length();i++){
            char t = temp.charAt(i);
            sb.append(t);
            fun(digits,index+1,sb);
             sb.setLength(len);
            }
    }
}