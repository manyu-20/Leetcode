class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String,List<String>> hm = new HashMap<>();
        return fun(s,wordDict,hm);
    }
    
    private List<String> fun(String s,List<String> wordDict,HashMap<String,List<String>> hm){
        if(hm.containsKey(s)){
            return hm.get(s);
        }
        List<String> res = new ArrayList<>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> sublist = fun(s.substring(word.length()),wordDict,hm);
                for(String sb : sublist){
                    res.add(word + (sb.isEmpty() ? "" : " ") + sb);
                }
            }
        }
        hm.put(s,res);
        return res;
    }
}