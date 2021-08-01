class Solution {
    static int n;
    static int m;
    public boolean searchMatrix(int[][] matrix, int target) {
        n = matrix.length;
        m = matrix[0].length;
        int i = 0;
        int j = matrix[0].length-1;
        return fun(i,j,matrix,target);
        
    }
    
    private boolean fun(int i,int j,int[][] matrix,int target){
        if(matrix[i][j] == target){
            return true;
        }
        if(target < matrix[i][j]){
            if(safe(i,j-1)){
                return fun(i,j-1,matrix,target);
            }
            return false;
        }
        else if(target > matrix[i][j]){
            if(safe(i+1,j)){
                return fun(i+1,j,matrix,target);
            }
            return false;
        }
        return false;
    }
    
    private boolean safe(int i,int j){
        return i>=0 && j>=0 && i< n && j <m;
    }
}