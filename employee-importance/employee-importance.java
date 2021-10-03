/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> emp, int id) {
        for(int i = 0;i<emp.size();i++){
            if(emp.get(i).id == id){
                List<Integer> ls = new ArrayList<>(emp.get(i).subordinates);
                if(ls.size() == 0){
                    return emp.get(i).importance;
                }
                else{
                    int sum = 0;
                    for(int x : ls){
                        sum = sum + getImportance(emp,x);
                    }
                    return sum + emp.get(i).importance;
                }
            }
        }
        return -1;
    }
}