class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1)==1){
            return false;
        }
        LinkedList<Integer> ll = new LinkedList<>();
        
        ll.add(0);
        int max = 0;
        
        while(!ll.isEmpty()){
            int rem = ll.removeFirst();
            if(rem == n-1){
                return true;
            }
            
            for(int i = Math.max(rem+minJump,max);i<=Math.min(n-1,rem+maxJump);i++){
                if(s.charAt(i) == '0'){
                   ll.addLast(i); 
                }
                
            }
            
            max = Math.min(n-1,rem+maxJump+1);
        }
        
        return false;
    }
}