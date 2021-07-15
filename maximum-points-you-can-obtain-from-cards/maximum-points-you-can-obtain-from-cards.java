class Solution {
    public int maxScore(int[] card, int k) {
        int len = card.length;
        
        for(int i = 1;i<len;i++){
            card[i] = card[i-1] + card[i];
        }
                if(len == k){
            return card[len-1];
        }
        int size = len - k;
        int i = 0;
        int j = size - 1;
        int max = -1;
        while(j < len){
            int rightSum = 0;
            if(i != 0){
                rightSum = card[i-1];
            }
            int leftSum = card[len-1] - card[j];
            max = Math.max(max,leftSum+rightSum);
            i++;
            j++;
        }
        return max;
        
    }
}