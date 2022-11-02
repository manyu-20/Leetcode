class Solution {
    public int minMutation(String start, String end, String[] bank) {
        min = Integer.MAX_VALUE;
        fun(start,end,bank,new boolean[bank.length],0);
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
    static int min;
    private void fun(String start,String end,String[] bank,boolean[] vis,int count){
        if(start.equals(end)){
            min = Math.min(min,count);
        }

        for(int i = 0;i<bank.length;i++){
            if(check(start,bank,i) == 1 && !vis[i]){
                vis[i] = true;
                fun(bank[i],end,bank,vis,count+1);
                vis[i] = false;
            }
        }
    }
    
    private int check(String start,String[] bank,int index){
        int count = 0;
        for(int i = 0;i<start.length();i++){
            if(start.charAt(i) != bank[index].charAt(i)){
                count++;
            }
            if(count > 1){
                return -1;
            }
        }
        
        return 1;
    }
}