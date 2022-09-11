class Solution {
    public int minGroups(int[][] intervals) {
        int[] arr = new int[1000002];
        
        for(int i = 0;i<intervals.length;i++){
            int u = intervals[i][0];
            int v = intervals[i][1];
            arr[u]++;
            arr[v+1]--;
        }
        
        int max = 0;
        int sum = 0;
        for(int i = 0;i<1000002;i++){
            sum += arr[i];
            max = Math.max(max,sum);
        }
        return max;
    }
}