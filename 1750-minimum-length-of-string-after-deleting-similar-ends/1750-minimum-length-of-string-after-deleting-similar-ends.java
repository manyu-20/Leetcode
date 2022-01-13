class Solution {
    public int minimumLength(String s) {
        if(s.length() == 1){
            return 1;
        }
 
        char[] array = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i < j && array[i] == array[j]){
            char same = array[i];
            while(i < j && array[i] == same) {
                array[i] = '?';
                i++;
            }

            while(i<=j && array[j] == same){
                array[j] = '?';
                j--;
            }
        }
        int count = 0;
        for(char c : array){
            if( c!= '?'){
                count++;
            }
        }
        return count;
    }
}