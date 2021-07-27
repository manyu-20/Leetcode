class Solution {
    static int[] dpleft;
    static int[] dpright;
    public int trap(int[] height) {
        int len =  height.length;
        dpleft = new int[len+1];
        dpright = new int[len+1];
        Arrays.fill(dpleft,-1);
        Arrays.fill(dpright,-1);
        int ans = 0;
        for(int i = 0;i<len;i++){
            int leftmax = left(height,i);
            int rightmax = right(height,i);
            ans += Math.min(leftmax,rightmax) - height[i];
        }
        return ans;
    }
    private int left(int[] height,int i){
        int index = i;
        int max = -1;
        if(dpleft[i] != -1){
            return dpleft[i];
        }
        while(i >= 0 ){
            max = Math.max(height[i],max);
            
            i--;
        }
        return dpleft[index] = max;
    }
    private int right(int[] height,int i){
         int index = i;
        int max = -1;
        if(dpright[i] != -1){
            return dpright[i];
        }
        while(i < height.length ){
            max = Math.max(height[i],max);
            
            i++;
        }
        return dpright[index] = max;
    }
}