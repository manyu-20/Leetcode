class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];
        for(int i = 0;i<logs.length;i++){
            int start = logs[i][0];
            int end = logs[i][1];
            while(start < end){
                arr[start - 1950]++;
                start++;
            }
        }
        int max = 0;
        int res = 0;
        for(int i = 0;i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
                res = i + 1950;
            }
        }
        return res;
    }
}