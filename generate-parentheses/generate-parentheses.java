class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder("");
        int left = 0;
        int right = 0;
        fun(new StringBuilder(),left,right,n);
        return list;
    }
    
    private void fun(StringBuilder sb,int left,int right,int max){
        if(sb.length() == max * 2){
            list.add(sb.toString());
            return;
        }
        if(left < max){
            sb.append("(");
            fun(sb,left+1,right,max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(")");
            fun(sb,left,right+1,max);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}