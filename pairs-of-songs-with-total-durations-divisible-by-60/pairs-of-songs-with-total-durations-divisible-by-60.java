class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        HashMap<Integer,Integer> hm =  new HashMap<>();
        for(int t : time){
            int reduced = t%60;
            int other = (reduced == 0) ? 0 : 60 - reduced;
            count += hm.getOrDefault(other,0);
            hm.put(reduced,hm.getOrDefault(reduced,0)+1);
        }
        return count;
            
    }
}