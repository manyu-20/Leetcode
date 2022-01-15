class Solution {
    public List<String> printVertically(String s) {
        int max = 0;
        String[] arr = s.split("\\s");
        List<String> list = new ArrayList<>();
        int start = 0;
        
        for(String x : arr){
            max = Math.max(max,x.length());
        }
        
        for(int i=1;i<=max;i++){
            list.add("");
        }
        
        for(String x : arr){
            
            for(int i = 0;i<x.length();i++){
                
                    StringBuilder sb = new StringBuilder("");
                    sb.append(list.get(i));
                    sb.append(String.valueOf(x.charAt(i)));
                    list.set(i,sb.toString());
                
            }
            
            
            for(int i = x.length();i<list.size();i++){
                StringBuilder sb = new StringBuilder("");
                sb.append(list.get(i));
                sb.append(" ");
                list.set(i,sb.toString());
            }
            
        }
        int i = 0;
        for(String x : list){
            String result = x.stripTrailing();
            // System.out.println(x);
            list.set(i,result);
            i++;
        }
        
        return list;
    }
}