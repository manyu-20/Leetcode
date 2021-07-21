class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c : t.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int left = 0;
        int right = 0;
        int count = hm.size();
        int min = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        StringBuilder sb = new StringBuilder();
        while(right < m){
            char in = s.charAt(right++);
            if(hm.containsKey(in)){
                hm.put(in,hm.get(in)-1);
                if(hm.get(in) == 0){
                    count--;
                }
            }
            if(count == 0){
                while(count == 0){
                    if(min > (right - left)){
                        minLeft = left;
                        min = right - left;
                        minRight = right;
                    }
                    char out = s.charAt(left);
                    if(hm.containsKey(out)){
                         hm.put(out,hm.get(out)+1);
                        if(hm.get(out) > 0){
                            count++;
                        }
                    }
                    left++;
                }
            }
        }
        // System.out.println(minLeft + "  "  + minRight);
        return s.substring(minLeft,minRight);
    
    }
}