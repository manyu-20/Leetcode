class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder("");
        
        PriorityQueue<pair>  pq =  new PriorityQueue<>((a,b) -> a.x - b.x);
        int n = indices.length;
        for(int i = 0;i<n;i++){
            String put = String.valueOf(s.charAt(i));
            pq.add(new pair(indices[i],put));
        }
        while(!pq.isEmpty()){
            sb.append(pq.remove().y);
        }
        return sb.toString();
    }
    
    static class pair{
        int x;
        String y;
        pair(int x,String y){
            this.x = x;
            this.y = y;
        }
    }
}