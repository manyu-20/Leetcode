class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int[] slot : intervals){
            
            if(newInterval[1] < slot[0]){
                arr.add(newInterval);
                newInterval = slot;
            }
            
            else if(newInterval[0] > slot[1]){
                arr.add(slot);
            }
            
            else{
                newInterval[0] = Math.min(slot[0],newInterval[0]);
                newInterval[1] = Math.max(slot[1],newInterval[1]);
            }
        }
        
        arr.add(newInterval);
        
        int[][] res = new int[arr.size()][2];
        
        for(int i = 0;i<arr.size();i++){
            res[i] = arr.get(i);
        }
        
        return res;
    }
}