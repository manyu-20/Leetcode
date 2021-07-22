class Solution {
    static int[][] arr;
    public int numDistinct(String s, String t) {
        arr = new int[s.length()+1][t.length()+1];
        for(int i = 0;i<=s.length();i++){
            Arrays.fill(arr[i],-1);
        }
        
        return fun(s.toCharArray(),t.toCharArray(),0,0);
    }
    
    private int fun(char[] s,char[] t,int indexs,int indext){
        if(indext == t.length){
            return 1;
        }
        if(indexs == s.length){
            return 0;
        }
        if(arr[indexs][indext] != -1){
            return arr[indexs][indext];
        }
        if(s[indexs] == t[indext]){
            arr[indexs+1][indext+1] = fun(s,t,indexs+1,indext+1);
            arr[indexs+1][indext] = fun(s,t,indexs+1,indext);
            return  arr[indexs+1][indext+1] + arr[indexs+1][indext];
        }
        else{
            return arr[indexs+1][indext] =  fun(s,t,indexs+1,indext);
        }
    }
}