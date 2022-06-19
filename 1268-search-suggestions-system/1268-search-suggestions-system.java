class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        HashMap<Integer,PriorityQueue<String>> hm = new HashMap<>();
        
        for(int i = 0;i<products.length;i++){
            int count = fun(searchWord,products[i]);
            PriorityQueue<String> pq;
            if(hm.containsKey(count)){
                pq = new PriorityQueue<>(hm.get(count));
                pq.add(products[i]);
                hm.put(count,pq);
            }
            else{
                pq = new PriorityQueue<>();
                pq.add(products[i]);
                hm.put(count,pq);
            }
        }
        
        System.out.println(hm);
        
        
        
        List<List<String>> ls = new ArrayList<>();
        
        for(int i = 1;i<= searchWord.length();i++ ){
            int take = i;
            List<String> temp = new ArrayList<>();
            int size = 3;
            for(int j = take ; j <= searchWord.length();j++){
                if(size == 0)break;
                
                if(hm.containsKey(j)){
                    PriorityQueue<String> pq = new PriorityQueue<>(hm.get(j));
                    while(!pq.isEmpty()){
                        temp.add(pq.peek());
                        pq.remove();
                    }
                }
            }
            Collections.sort(temp);
            ArrayList<String> insert = new ArrayList<>();
            for(int l = 0;l<3 && l< temp.size();l++){
                insert.add(temp.get(l));
            }
            ls.add(new ArrayList<>(insert));
        }
        
        return ls;
        
        
        
    }
    
    int fun(String first,String sec){
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < first.length() & j < sec.length()){
            if(first.charAt(i) == sec.charAt(j)){
                count++;
            }
            else{
                return count;
            }
            i++;
            j++;
        }
        
        return count;
    }
}