class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n+1];
        
        for(int i = 0;i<trust.length;i++){
            int a = trust[i][0];
            int b = trust[i][1];
            arr[b]++;
            arr[a]--;
        }
        
        for(int i = 1;i<arr.length;i++){
            if(arr[i] == n-1){
                return i;
            }
        }
        return -1;
        
    }
}