class Solution {
    // ArrayList<Integer> list;
    HashSet<Integer> list;
    public int[] numsSameConsecDiff(int n, int k) {
        list  = new HashSet<>();
        for(int i = 1;i<=9;i++){
            fun(i,1,n,k);
        }
        int[] arr = new int[list.size()];
        int i = 0;
        for(int x : list){
            arr[i++] = x;
        }
        Arrays.sort(arr);
        return arr;
    }
    // 25  258  252
    void fun(int num,int len,int n,int k){

        if(len == n){
            list.add(num);
            return;
        }
        int lastDigit = num % 10;
        if(lastDigit + k <= 9){
            int big = (num * 10) + lastDigit + k;
            fun(big,len+1,n,k);
        }
        if(lastDigit - k >= 0){
            int small = (num * 10) + lastDigit - k;
            fun(small,len+1,n,k);
        }
    }
}