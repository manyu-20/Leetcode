class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0;i<A.length;i++){
            if(A[i] < 0)A[i] = 0;
        }
        
        for(int i = 0;i<A.length;i++){
            int val = Math.abs(A[i]);
            if(val>=1 && val <= A.length){
                if(A[val - 1] > 0){
                    A[val - 1] = -1*A[val - 1];
                }
                else if(A[val - 1] == 0){
                    A[val -1] = -1 * (A.length + 1);
                }
            }
        }
        
        for(int i = 1;i<=A.length;i++){
            if(A[i-1] >= 0){
                return i;
            }
        }
        return A.length + 1;
    }
}