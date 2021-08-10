class Solution {
    public int videoStitching(int[][] clips, int t) {
        int end = 0;
        int count = 0;
        int far = 0;
        Arrays.sort(clips,(a,b)->a[0]-b[0]);

        for(int i = 0;end < t;end = far){
            count++;
            
            while(i < clips.length && clips[i][0] <= end){
                far = Math.max(far,clips[i][1]);
                i++;
            }
            
            if(far == end){
                return -1;
            }
            
        }
        
        return count;
        
        
    }
}