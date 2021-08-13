class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;
        int count = 0;
        while(i < j){
            if(people[i] + people[j] <= limit){
                count++;
                people[i] = people[j] = -1;
                i++;
                j--;
                
            }
            else{
                j--;
            }
        }
        for(int p = 0;p<people.length;p++){
            if(people[p] != -1){
                count++;
            }
        }
        return count;
    }
}