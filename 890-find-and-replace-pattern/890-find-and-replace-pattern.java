class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = words.length;
        List<String> ls = new ArrayList<>();
        for(int i = 0;i<n;i++){
            HashMap<Character,Character> patToWord = new HashMap<>();
            HashMap<Character,Character> wordToPat = new HashMap<>();

            
            String word = words[i];
            
            if(word.length() == pattern.length()){
                // System.out.println("hello");
                boolean is = true;
                int j = 0;
                while(j < word.length()){
                    char w = word.charAt(j);
                    char p = pattern.charAt(j);
                    if(patToWord.containsKey(p) && patToWord.get(p) != w){
                        is = false;
                        break;
                    }
                    else if(!patToWord.containsKey(p)){
                        if(wordToPat.containsKey(w) && wordToPat.get(w) != p){
                            is = false;
                            break;
                        }
                        else{
                            patToWord.put(p,w);
                            wordToPat.put(w,p);
                        }
                    } 
                    j++;
                }
                
                if(is){
                    ls.add(word);
                }
            }
            
        }
        
        return ls;
    }
}