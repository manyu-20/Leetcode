class Solution {
    public void setZeroes(int[][] matrix) {
        int row = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        row = 0;
                        matrix[0][j] = 0;
                    }
                    else{
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("row = " + row);
        
        for(int i = rows-1;i>=0;i--){
            for(int j = cols-1;j>=0;j--){
                if(i == 0){
                    if(row == 0){
                        matrix[i][j] = 0;
                    }
                    // System.out.println("row = " + row +" " + "true");
                    // matrix[i][j] = 0;
                }
                else{
                   if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                       matrix[i][j] = 0;
                   }
                }
            }
        }
        
    }
}