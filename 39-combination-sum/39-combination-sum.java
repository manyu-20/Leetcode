class Solution {
    HashSet<ArrayList<Integer>> hs;
    public List<List<Integer>> combinationSum(int[] A, int B) {
         hs = new HashSet<>();
        fun(0,A,B,new ArrayList<Integer>());
        List<List<Integer>> arr = new ArrayList<>();
        
        for(ArrayList<Integer> temp : hs ){
            ArrayList<Integer> temp2 = new ArrayList<>(temp);
            // Collections.sort(temp2);
            arr.add(new ArrayList<>(temp2));
        }
        return arr;
    }
    
    void fun(int index,int[] A,int target,ArrayList<Integer> temp){
        if(target == 0){
            hs.add(new ArrayList<>(temp));
            return;
        }
        if(index >= A.length || target < 0){
            return;
        }
        temp.add(A[index]);
        fun(index,A,target - A[index],temp);
        fun(index+1,A,target - A[index],temp);
        temp.remove(temp.size()-1);
        fun(index+1,A,target,temp);
    }
}