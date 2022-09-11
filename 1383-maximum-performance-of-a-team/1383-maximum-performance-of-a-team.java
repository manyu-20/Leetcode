class Solution {
    int mod = 1_000_000_007;
    public int maxPerformance(int n, int[] speed, int[] eff, int k) {
        int[][] arr = new int[n][2];
        
        for(int i = 0;i<n;i++){
            arr[i][0] = eff[i];
            arr[i][1] = speed[i];
        }
        
        Arrays.sort(arr, (a,b) -> b[0] - a[0]);
        
        long res = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        long total = 0;
        for(int i = 0;i<n;i++){
            if(pq.size() == k){
                total -= pq.peek();
                pq.remove();
            }
            pq.offer(arr[i][1]);
            total += arr[i][1];
            res = Math.max(res, (total * arr[i][0]));
        }
        
        return (int) (res % mod);
        
        
        
    }
}