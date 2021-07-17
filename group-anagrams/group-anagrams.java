class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String,List> hm = new HashMap<>();
        for(String s : strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!hm.containsKey(key))hm.put(key,new ArrayList<>());
            hm.get(key).add(s);
        }
        
        return new ArrayList(hm.values());
    }
}