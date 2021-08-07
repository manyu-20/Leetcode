class Solution {
    static int n,m;
    public int kthSmallest(int[][] matrix, int k) {
        n = matrix.length;
        m = matrix[0].length;
        int row = n-1;
        int col = m-1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        pq.add(matrix[row][col]);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                pq.add(matrix[i][j]);
                
                if(pq.size() > k){
                    pq.remove();
                }
            }
        }
        if(!pq.isEmpty()){
            return pq.remove();
        }
        return -1;
    }
    
    // static isSafe(int i,int j,int[][] matrix){
    //     return i >=0 && j >=0 && i < n && j < m;
    // }
}