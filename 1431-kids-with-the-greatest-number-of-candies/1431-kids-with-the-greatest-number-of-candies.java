class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int x : candies){
            max = Math.max(x,max);
        }
        ArrayList<Boolean> list = new ArrayList<>();
        for(int x : candies){
            if(x + extraCandies >= max){
                list.add(Boolean.TRUE);
            }
            else list.add(Boolean.FALSE);
        }
        return list;
    }
}