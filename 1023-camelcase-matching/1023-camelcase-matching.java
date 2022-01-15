class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        ArrayList<Boolean> list = new ArrayList<>();
        for(String x : queries){
            char[] q = x.toCharArray();
            char[] pat = pattern.toCharArray();
            int i = 0;
            int j = 0;
            while(i < pat.length){
                if(j >=q.length){
                    break;
                }
                if(pat[i] == q[j]){
                    q[j] = '?';
                    i++;
                    j++;
                }
                else{
                    j++;
                }
            }
            
            if(i >= pat.length){
                boolean is = true;
                for(int k = 0;k<q.length;k++){
                    if(q[k] != '?' && Character.isUpperCase(q[k])){
                        is = false;
                    }
                }
                
                if(is){
                    list.add(Boolean.TRUE);
                }
                else{
                    list.add(Boolean.FALSE);
                }
            }
            else{
                 list.add(Boolean.FALSE);
            }
            
        }
        
        return list;
    }
}