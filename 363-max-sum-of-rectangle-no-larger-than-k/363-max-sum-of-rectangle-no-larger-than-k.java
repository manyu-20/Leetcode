class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        // int sum = 0;
        for(int i = 0;i < n;i++){
            int sum = 0;
            for(int j = 0;j<m;j++){
                sum = sum + matrix[i][j];
                matrix[i][j] = sum;
            }
        }
        
        for(int j = 0;j<m;j++){
            int sum = 0;
            for(int i = 0;i<n;i++){
                sum = sum + matrix[i][j];
                matrix[i][j] = sum;
            }
        }
        
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<m;j++){
        //         System.out.print(i + " " + j + " = " + matrix[i][j]+"    ");
        //     }
        //     System.out.println();
        // }
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                
                for(int start = i;start < n;start++){
                    int sum = 0;
                    for(int end = j;end < m;end++){
                        sum = 0;
                        sum = sum + matrix[start][end];
                        if(i-1 >=0 && end >= 0){
                            // top
                             // System.out.println(matrix[i-1][end]);
                            sum = sum - matrix[i-1][end];
                        }
                        if(start >= 0 && j-1 >= 0){
                            //left
                            // System.out.println(matrix[start][j-1]);

                            sum = sum - matrix[start][j-1];
                        }
                        if(i-1 >= 0 && j - 1 >= 0){
                            // System.out.println(matrix[i-1][j-1]);

                            sum = sum + matrix[i-1][j-1];
                        }
                        
                        if(sum <= k){
                       max = Math.max(max,sum);
                    }
                                            // System.out.println(sum + " is area of " + i + "  "  + j + " " + start +" " + end);
                    }
                                                 // System.out.println("hello");


                    
                }
            }
        }
        
        return max;
    }
}