class Solution {
    public int nextGreaterElement(int n) {
        char[] number =  (n+"").toCharArray();
        int len = number.length;
        int i;
        for(i = len-1;i>=1;i--){
            if(number[i-1] < number[i] ){
                break;
            }
        }
        
        if(i == 0){
            return -1;
        }
        int bigger = number[i-1];
        int index = i-1;
        for(int j = i; j<len;j++){
            if(number[j] > number[i-1]){
                int num = Character.getNumericValue(number[j]);
                if(num < bigger){
                    bigger = num;
                    index = j;
                }
            }
        }
        
        char temp = number[index];
        number[index] = number[i-1];
        number[i-1] = temp;
        
        Arrays.sort(number,i,len);
        
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
        
        

    }
}