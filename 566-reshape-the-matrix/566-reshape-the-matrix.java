class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if((n == r && m == c) || (n*m != r * c)){
            return mat;
        }
        int[][] matrix = new int[r][c];
        int start = 0;
        int end = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                matrix[start][end] = mat[i][j];
                end++;
                if(end == c){
                    end = 0;
                    start++;
                }
            }
        }
        return matrix;
    }
}