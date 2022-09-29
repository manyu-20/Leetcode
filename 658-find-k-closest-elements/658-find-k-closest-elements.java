class Solution {
    static class pair{
        int x,y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] ans = new int[k];
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.y == b.y ? b.x - a.x : b.y - a.y);
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            int ele = arr[i];
            int diff = Math.abs(x - ele);
            pq.add(new pair(ele,diff));
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        while(!pq.isEmpty()){
            list.add(pq.remove().x);
        }
        Collections.sort(list);
        return list;
        
    }
}