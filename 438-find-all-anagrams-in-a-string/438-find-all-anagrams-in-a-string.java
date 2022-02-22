class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char c : p.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        List<Integer> ls = new ArrayList<>();
        int i = 0; 
        int j = 0;
        
        int count = hm.size();
        int n = s.length();
        int k = p.length();
        
        while(j < n){
            char c = s.charAt(j);
            
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if(hm.get(c) == 0){
                    count--;
                }
            }
            
            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                if(count == 0){
                    ls.add(i);
                }
                char atI = s.charAt(i);
                if(hm.containsKey(atI)){
                    if(hm.get(atI) == 0){
                        count++;
                    }
                    hm.put(atI,hm.get(atI)+1);
                    
                }
                i++;
                j++;
                
            }
        }
        
        return ls;
            
    }
}