class Solution {
    static int m = 1_000_000_007;
    public int numSub(String s) {
        int[] arr = new int[s.length()];
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                count++;
                arr[i] = count;
            }
            else{
                count = 0;
                arr[i] = 0;
            }
        }
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum = (sum + arr[i])%m;
        }
        return sum;
        
    }
}