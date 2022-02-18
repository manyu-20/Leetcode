class Solution {
    public int lastStoneWeightII(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int a : arr) sum += a;

        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1])
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }
        for (int i = sum / 2; i >= 0; --i)
            if (dp[n][i]) return sum - i - i;
        return 0;
    }
}