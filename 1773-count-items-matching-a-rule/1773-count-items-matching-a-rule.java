class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(int i = 0;i<items.size();i++){
            List<String> list = new ArrayList<>(items.get(i));
            String type = list.get(0);
            String color = list.get(1);
            String name = list.get(2);
            
            if(ruleKey.equals("type") && ruleValue.equals(type))count++;
            else if(ruleKey.equals("color") && ruleValue.equals(color))count++;
            else if(ruleKey.equals("name") && ruleValue.equals(name))count++;
        }
        
        return count;
    }
    
}