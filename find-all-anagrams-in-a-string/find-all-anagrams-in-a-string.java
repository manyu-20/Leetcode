class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0){
            return list;
        }
        int[] arr = new int[26];
        
        for(int i = 0;i<p.length();i++){
            char c = p.charAt(i);
            arr[c - 'a']++;
        }
        
        int left = 0;
        int right = 0;
        int count = p.length();
        while(right < s.length()){
            char c = s.charAt(right++);
            if(arr[c - 'a']-- >= 1 ){
                count--;
            }
            if(count == 0){
                list.add(left);
            }
            if(right - left == p.length() && arr[s.charAt(left++) -'a']++ >=0 ){
                count++;
            }
        }
        return list;
    }
}