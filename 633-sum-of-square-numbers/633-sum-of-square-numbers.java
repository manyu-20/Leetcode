class Solution {
    public boolean judgeSquareSum(int c) {
        int powMax = (int) Math.sqrt(c);
        long i = 0;
        long j = powMax;
        while (i <= j) {
            long sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (c > sum) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}