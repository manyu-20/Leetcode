class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder ans = new StringBuilder(s);
        long shift=0;
        for (int i = s.length()-1; i >=0 ; i--){
            ans.setCharAt(i, (char)((s.charAt(i) - 'a' + (shift+shifts[i]) % 26) % 26 + 'a'));
            shift+=shifts[i];
        }
        return ans.toString();
    }
}