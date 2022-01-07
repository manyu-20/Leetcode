class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;
            
        for(int i = 0;i<n;i++){
            reverse(image[i]);
            invert(image[i]);
        }
        return image;
    }
    
    private void reverse(int[] arr){ 
        int n = arr.length;
        int i = 0;
        int j = n-1;
        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    
    private void invert(int[] arr){  
        int n = arr.length;
        for(int i = 0;i<n;i++){
            if(arr[i] == 1){
                arr[i] = 0;
            }
            else arr[i] = 1;
        }
    }
}