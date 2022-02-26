class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> hm = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int n = s.length();
        int k = 10;
        while(j < n){
            
            if(j-i+1 < k){
                j++;    
            }
            else if(j-i+1 == k){
                String str = new String(s.substring(i,j+1));
                hm.put(str,hm.getOrDefault(str,0)+1);
                j++;
            }
            else if(j-i+1 > k){
                while(j-i+1 > k){
                    i++;
                }
                // j++;
            }
        }
        List<String> list = new ArrayList<>();
        for(String str : hm.keySet()){
            if(hm.get(str) > 1){
                list.add(str);
            }
        }
        
        return list;
    }
}