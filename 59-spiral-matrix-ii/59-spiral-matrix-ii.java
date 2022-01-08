class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        
        int top = 0;
        int bottom = arr.length-1;
        int left = 0;
        int right = arr[0].length - 1;
        int start = 1;
        while(top <= bottom && left <= right){
            // go right
            for(int i =left;i<=right;i++){
                arr[top][i] = start;
                start++;
            }
            top++;
            
            //go bottom
            for(int i = top;i<=bottom;i++){
                arr[i][right] = start;
                start++;
            }
            right--;
            
            if(left > right && top > bottom){
                break;
            }
            
            //go left
            for(int i =right;i>=left;i--){
                arr[bottom][i] = start;
                start++;
            }
            bottom--;
            
            //go upward
            for(int i = bottom;i>= top;i--){
                arr[i][left] = start;
                start++;
            }
            left++;
            
        }
        
        return arr;
        
    }
}