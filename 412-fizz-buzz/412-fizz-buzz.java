class Solution {
    public List<String> fizzBuzz(int n) {
        int i = 1;
        List<String> ls = new ArrayList<>();
        while(i <= n){
            if(i % 5 == 0 && i %3 == 0){
                ls.add("FizzBuzz");
            }
            else if(i % 5 == 0){
                ls.add("Buzz");
            }
            else if(i %3 == 0){
                ls.add("Fizz");
            }
            else{
                ls.add(String.valueOf(i));
            }
            i++;
        }
        
        return ls;
    }
}