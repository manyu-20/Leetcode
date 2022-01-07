class Solution {
    public int[] sumZero(int n) {
        if(n == 1){
            return new int[]{0};
        }
        int[] arr = new int[n];
        if(n%2 == 0){
            int start = -1;
            int i = 0;
            while(i < n/2){
                arr[i] = start;
                start--;
                i++;
            }
            start = 1;
            while(i< n){
                arr[i] = start;
                start++;
                i++;
            }
        }
        else{
            arr[0] = 0;
            int start = -1;
            int i = 1;
            while(i <= n/2){
                arr[i] = start;
                start--;
                i++;
            }
            start = 1;
            while(i<  n){
                arr[i] = start;
                start++;
                i++;
            }
        }
        
        return arr;
    }
}