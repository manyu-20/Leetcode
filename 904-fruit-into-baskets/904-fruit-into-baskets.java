class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        
        
        int i = 0;
        int j = 0;
        int n = fruits.length;
        int max = 1;
        
        int same = fruits[0];
        boolean isSame = true;
        for(int k = 1;k<n;k++){
            if(same != fruits[k]){
                isSame = false;
            }
        }
        
        if(isSame){
            return n;
        }
        
        while(j < n){
            hm.put(fruits[j],hm.getOrDefault(fruits[j],0)+1);
            
            if(hm.size() < 2){
                j++;
            }
            else if(hm.size() == 2){
                max = Math.max(max,j-i+1);
                j++;
            }
            else if(hm.size() > 2){
                while(hm.size() != 2){
                    hm.put(fruits[i],hm.get(fruits[i])-1);
                    if(hm.get(fruits[i]) == 0){
                        hm.remove(fruits[i]);
                    }
                    i++;
                }
                j++;
            }
        }
        
        return max;
    }
}