class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {

        char[] letters = s.toCharArray();
        int l = 0, r = removable.length;
        while (l <= r) {
            int mid = (l+r)/2;
            for (int i=0;i<mid;i++) letters[removable[i]] = '/';

            if (check(letters,p)) l = mid+1;

            else {
                for (int i=0;i<mid;i++) letters[removable[i]] = s.charAt(removable[i]);
                r = mid-1;
            }
        }
        return r;
    }
    

    public boolean check(char[] letters, String p) {
        int i1 = 0, i2 = 0;
        while (i1 < letters.length && i2 < p.length()) {
            char curr = letters[i1], curr2 = p.charAt(i2);
            if (curr != '/' && curr == curr2) i2++;
            i1++;
        }
        

        if (i2 == p.length()) return true;
        return false;
    }
}