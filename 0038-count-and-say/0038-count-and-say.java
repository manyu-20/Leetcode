class Solution {
    public String countAndSay(int n) {
        return fun(1,n,"1");
    }
    
    String fun(int i,int n,String start){
        if(i == n){
            return start;
        }
        StringBuilder sb = new StringBuilder("");

        int index = 0;
        while(true){
            int val = Integer.parseInt(String.valueOf(start.charAt(index)));
            int count = 0;
            while(index < start.length() && val == Integer.parseInt(String.valueOf(start.charAt(index)))){
                count++;
                index++;
            }
            sb.append(count+""+val);
            if(index >= start.length()){
                break;
            }
        }

        return fun(i+1,n,sb.toString());
        
        
    }
}