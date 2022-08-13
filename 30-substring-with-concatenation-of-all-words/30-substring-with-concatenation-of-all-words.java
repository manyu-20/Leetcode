class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ll=new ArrayList<>();
        HashMap<String,Integer> hm=new HashMap<>();
        fill(hm,words);
        int len=words[0].length();int total=len*words.length;
        for(int i=0;i<=s.length()-total;i++){
            String a=s.substring(i,i+total);
            int flag=0;
            for(int j=0;j<a.length();j+=len){
                String b=a.substring(j,j+len);
                if(!hm.containsKey(b) || (hm.containsKey(b) && hm.get(b)==0)){
                    flag=1;break;
                }
                else{
                    hm.put(b,hm.get(b)-1);
                }
            }
            if(flag==0) ll.add(i);
            hm=new HashMap<String,Integer>();
            fill(hm,words);
        }
        return ll;
    }
    public void fill(HashMap<String,Integer> hm, String words[]){
        for(int i=0;i<words.length;i++){
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }
        return ;
    }
}