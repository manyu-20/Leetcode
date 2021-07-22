class Solution {
    static int[] arr;
    public boolean wordBreak(String s, List<String> wordDict) {
        arr = new int[301];
        //0 not checked
        //1 not possible
        //2 possible
        HashSet<String> hs = new HashSet<>();
        for (String item:wordDict){
            hs.add(item);
        }
        return fun(s,hs,0);
    }
    private boolean fun(String s,HashSet<String> hs,int index){
        if(index >= s.length()){
            return true;
        }
        if(arr[index]!=0){
            if(arr[index] == 1){
                return false;
            }
            else{
                return true;
            }
        }
        boolean is = false;
        for(int i = index+1;i<=s.length();i++){
            String temp = s.substring(index,i);
            if(hs.contains(temp)){
                is =  fun(s,hs,i);
                if(is){
                    arr[index] = 2;
                    return true;
                }
            }
        }
        if(is){
            arr[index] = 2;
        }
        if(!is){
            arr[index] = 1;
        }
        return is;
    }
}