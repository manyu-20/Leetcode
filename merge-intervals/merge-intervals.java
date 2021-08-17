class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 1;i<intervals.length;i++){
            int first = intervals[i][0];
            int sec = intervals[i][1];
            
            if(end >= first){
                end = Math.max(end,sec);
            }
            else{
                arr.add(new int[]{start,end});
                start = first;
                end = sec;
            }
        }
        arr.add(new int[]{start,end});
        int[][] res = new int[arr.size()][2];
        int index = 0;
        for(int[] item : arr){
            res[index][0] = item[0];
            res[index][1] = item[1];
            index++;
        }
        
        return res;
    }
}