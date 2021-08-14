class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        if(s1.length() == 1 && s2.length() == 1){
            return true;
        }
        return fun(s1,s2) || fun(s2,s1);
    }
    
    boolean fun(String first,String two){
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> a-b);
        char[] one = first.toCharArray();
        Arrays.sort(one);
        for (int i = 0;i<two.length();i++){
            pq.add(two.charAt(i));
        }
        int index = 0;
        while(!pq.isEmpty()){
            char c = one[index];
            if(c < pq.peek()){
                return false;
            }
            else{
                index++;
                pq.remove();
            }
        }
        return true;
        
    }
}