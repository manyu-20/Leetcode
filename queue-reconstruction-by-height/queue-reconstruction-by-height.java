class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->b[0]==a[0]?a[1]-b[1] : b[0]-a[0]);
        List<int[]> list = new ArrayList<>();
        for(int[] arr:people){
            list.add(arr[1],arr);
        }
        int[][] ans = new int[people.length][2];
        int index = 0;
        for(int[] arr : list){
            ans[index][0] = arr[0];
            ans[index][1] = arr[1];
            index++;
        }
        return ans;
    }
}