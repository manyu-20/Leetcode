class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int max = 0;
        
        int i = 0;
        int sum = 0;
        for(int j = 0;j<n;j++){
            sum = sum + arr[j];
            while(sum > maxCost){
                sum = sum - arr[i];
                i++;
            }
            max = Math.max(max,j-i+1);
        }
        
        
        return max;
        
        // for(int i = 1;i<n;i++){
        //     arr[i] = arr[i-1] + arr[i];
        // }
        // int max = 0;
        // int i = 0;
        // int j = 0;
        // while(i <= j && j < n){
        //     int sum = 0;
        //     if(i == 0){
        //         sum = sum + arr[j];
        //     }
        //     else{
        //         sum = sum + arr[j] - arr[i-1];
        //     }
        //     if(sum <= maxCost){
        //         max = Math.max(max,j-i+1);
        //         j++;
        //     }
        //     else{
        //         i++;
        //     }
        // }
        
    }
}