class Solution {
    public int countBinarySubstrings(String s) {
        int[] arr = new int[s.length()];
        int index = 0;
        arr[0] = 1;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) != s.charAt(i-1)){
                index++;
                arr[index] = 1;
            }
            else{
                arr[index]++;
            }
        }
        int count = 0;
        for(int i = 1;i<=index;i++){
            count = count + Math.min(arr[i],arr[i-1]);
        }
        return count;
        
    }
}