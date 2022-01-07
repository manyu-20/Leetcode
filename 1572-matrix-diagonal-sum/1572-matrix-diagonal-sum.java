class Solution {
    public int diagonalSum(int[][] mat) {
        if(mat.length == 1){
            return mat[0][0];
        }
        int n = mat.length;
        int sum1 = 0;
        int sum2 = 0;
        // 00 11 22
        // 03 12 21 30
        
        for(int i = 0;i<n;i++){
            sum1 = sum1 + mat[i][i];
        }
        int start = n-1;
        for(int i = 0;i<n;){
            sum2 = sum2 + mat[i][start];
            i++;
            start--;
        }
        int minus = 0;
        if(n%2 == 1){
           minus = mat[n/2][n/2];
        }
        
        return sum1 + sum2 - minus;
    }
}