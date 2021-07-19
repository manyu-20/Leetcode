class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s.length() == 0){
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        int len = s.length();
        int[] last = new int[26];
        for(int i = 0;i<len;i++){
            last[s.charAt(i)-'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i = 0;i<len;i++){
            end = Math.max(end,last[s.charAt(i) - 'a']);
            if(i == end){
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}