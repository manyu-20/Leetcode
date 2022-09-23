class Solution {
    public int concatenatedBinary(int n) {
        final long modulo = (long) (1e9 + 7);
        long result = 0;
        int no_of_bits = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) no_of_bits++;
            result = ((result << no_of_bits) + i) % modulo;  
        }
        return (int) result;
    }
}