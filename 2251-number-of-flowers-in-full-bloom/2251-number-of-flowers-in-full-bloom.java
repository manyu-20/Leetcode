class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]==b[0] ? a[1] - b[1] : a[0]-b[0]);
        // timeline , priority, *index
        for(int i = 0;i<persons.length;i++){
            pq.offer(new int[]{persons[i],1,i});
        }
        
        for(int i = 0;i < flowers.length; i++){
            pq.offer(new int[]{flowers[i][0],0});
            pq.offer(new int[]{flowers[i][1],2});
        }
        int count = 0;
        int[] res = new int[persons.length];
        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            if(arr[1] == 0){
                count++;
            }
            else if(arr[1] == 2){
                count--;
            }
            else{
                res[arr[2]] = count;
            }
        }
        
        return res;
    }
}