class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCost = 0;
        int oddCost = 0;
        for(int i = 0;i<position.length;i++){
            int ele = position[i];
            if(ele%2 == 0){
                evenCost++;
            }
            else oddCost++;
        }
        
        return Math.min(evenCost,oddCost);
        
    }
}