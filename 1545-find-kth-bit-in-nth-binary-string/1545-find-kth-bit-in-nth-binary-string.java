class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1){
            return '0';
        }
        StringBuilder sb = new StringBuilder("0");
        
        int count = 1;
        
        while(n > 1){
            StringBuilder temp = new StringBuilder("");
            temp.append(sb.toString());
            temp.append("1");
            for(int i = 0;i<sb.length();i++){
                if(sb.charAt(i) == '1'){
                    sb.setCharAt(i,'0');
                }
                else sb.setCharAt(i,'1');
            }
            temp.append(sb.reverse().toString());
            sb = new StringBuilder(temp.toString());
            n--;
        }
        return sb.charAt(k-1);
    }
}