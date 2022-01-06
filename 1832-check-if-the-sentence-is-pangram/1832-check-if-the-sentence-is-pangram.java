class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for(char c : sentence.toCharArray()){
            arr[c - 'a']++;
            
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0)return false;
        }
        return true;
    }
}