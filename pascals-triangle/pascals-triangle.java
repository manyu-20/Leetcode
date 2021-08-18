class Solution {
    static List<List<Integer>> list;
    public List<List<Integer>> generate(int numRows) {
        list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        list.add(new ArrayList<>(arr));
        if(numRows == 1){
            return list;
        }
        fun(numRows,2);
        return list;
    }
    
    void fun(int n,int index){
        if(index > n){
            return;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        ArrayList<Integer> curr = new ArrayList<>(list.get(index-2));
        for(int i = 0;i<=curr.size()-2;i++){
            int sum = curr.get(i) + curr.get(i+1);
            temp.add(sum);
        }
        temp.add(1);
        list.add(temp);
        fun(n,index+1);
        
    }
}