class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        
        char prev = '*';
        int res = 0;
        for(int i = s.length()-1;i>=0;i--){
            char curr = s.charAt(i);
            if(prev != '*'){
                if(hm.get(curr) < hm.get(prev)){
                    res = res - hm.get(curr);
                }
                else{
                    res = res + hm.get(curr);
                }
            }
            else{
                res = res + hm.get(curr);
            }
            prev = curr;
        }
        
        return res;
    }
}