class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;
        s = " "+s;
        String res = "";
        boolean f[][] = new boolean[n+1][n+1];
        for(int len =0; len<n; len++){
            for(int i=1; i+len<=n; i++){
                int j=i+len;
                if(len == 0) f[i][j] = true;
                else if(len == 1){
                    f[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    f[i][j] = f[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
                if(f[i][j] && j-i+1 > res.length()){
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
}