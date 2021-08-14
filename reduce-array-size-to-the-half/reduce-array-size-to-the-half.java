class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i) >= len/2) return 1;
        }
        
        List<Integer> orderedVal = new ArrayList<>(map.values());
        orderedVal.sort((a,b) -> b - a);
        
        int count = 0;
        int sum = 0;
        for(int val : orderedVal){
            sum += val;
            count++;
            if(sum >= len/2) return count;
        }
       return count;
    }
}