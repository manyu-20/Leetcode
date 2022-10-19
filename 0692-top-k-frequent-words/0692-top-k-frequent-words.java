class Solution {
    static class pack{
        int freq;
        String str;
        pack(int _freq,String _str){
            freq = _freq;
            str = _str;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
            PriorityQueue<pack> pq = new PriorityQueue<>((a,b) -> a.freq==b.freq ?b.str.compareTo(a.str):a.freq-b.freq);
        HashMap<String,Integer> hm = new HashMap<>();
        for(String x : words){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        for(String x : hm.keySet()){
            pq.add(new pack(hm.get(x),x));
            while(pq.size() > k){
                pq.remove();
            }
        }
        
        List<String> res = new ArrayList<>();
        
        while(!pq.isEmpty()){
            res.add(0,pq.peek().str);
            pq.remove();
        }
        return res;
        
            
    }
}