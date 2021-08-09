class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1] );
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0;
        for(int i = 1;i<intervals.length;){
            System.out.println("int = " + intervals[i][0] + " "  + intervals[i][1]);
            if(start == intervals[i][0] && intervals[i][1] == end){
                count++;
            }
            else if(end <= intervals[i][1] && end > intervals[i][0]){
                count++;
            }
            else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i = i + 1;
        }
        return count;
            
    }
}

// 1 2  1 3  2 3   3 4