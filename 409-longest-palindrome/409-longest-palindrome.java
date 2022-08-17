class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char c : s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        
        int max = 0;
        int even = 0;
        for(char x : hm.keySet()){
            if(hm.get(x) % 2 == 0){
                even = even + hm.get(x);
            }
            else{
                max = 1;
                even = even + hm.get(x)-1;
            }
        }
        
        if(max == 1){
            return even + 1;
        }
        else return even;
        
        
    }
}