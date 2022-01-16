class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return 0;
        }
        if(beginWord.equals(endWord)){
            return 1;
        }
        
        queue.add(beginWord);
        int count = 1; 
        while(queue.size()>0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                char[] word = queue.poll().toCharArray();

                for(int j=0; j<word.length; j++){
                    char tmp = word[j];
                    for(char c='a'; c<='z'; c++){
                        word[j] = c;
                        String newWord = new String(word);
                        if(dict.contains(newWord)){
                            if(newWord.equals(endWord)){
                                return count + 1;
                            }
                            queue.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                    word[j] = tmp; 
                }
            }
        
            count += 1; 
        }

        return 0;
    
    }
}