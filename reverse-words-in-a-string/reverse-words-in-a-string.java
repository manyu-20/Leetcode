class Solution {
    public String reverseWords(String s) {
    if (s == null || s.length() <= 0) return s;
    String[] words = s.split(" +");
    StringBuilder ret = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--)
        if (words[i].length() > 0) ret.append(words[i]).append(" ");
    return ret.toString().trim();
}
}