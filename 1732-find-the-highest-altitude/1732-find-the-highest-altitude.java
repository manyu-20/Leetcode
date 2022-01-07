class Solution {
    public int largestAltitude(int[] gain) {
        int start = 0;
        int max = start;
        for(int x : gain){
            start = start + x;
            max = Math.max(max,start);
        }
        return max;
    }
}