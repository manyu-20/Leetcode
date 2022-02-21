class Solution {
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        n--;
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,false);
        for(int i = 2;i <= n/2;i++){
            if(!arr[i]){
                for(int j = i * 2; j  <=  n;j =j + i){
                arr[j] = true;
            }
            }
        }
        int count = 0;
        for(int i = 2;i<=n;i++){
            if(!arr[i]){
                count++;
            }
        }
        
        return count;
        
        
    }
}