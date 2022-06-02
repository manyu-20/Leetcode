class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int n = intervals.length;
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int i = 1;i<n;i++){
            int first = intervals[i][0];
            int second = intervals[i][1];
            
            if(first >= start && first <= end){
                end = Math.max(end,second);
            }
            else{
                arr.add(new int[]{start,end});        
                start = first;
                end = Math.max(end,second);
            }
        }
        arr.add(new int[]{start,end});
        
        int[][] ans = new int[arr.size()][2];
        int index = 0;
        for(int[] put : arr){
            ans[index][0] = put[0];
            ans[index][1] = put[1];
            index++;
        }
        
        return ans;
    }
}