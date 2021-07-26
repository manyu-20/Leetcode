class Solution {
    public static final int max = (int) Math.pow(10, 9) + 7;
	
public int knightDialer(int n) {
   long M[][][] = new long[n + 1][4][3];
   long s = 0;
   for(int i = 0; i < 4; i++) {
      for(int j = 0; j < 3; j++) {
         s = (s + paths(M, i, j, n)) % max;
      }
   }
   return (int) s;
}

private long paths(long[][][] M, int i, int j, int n) {

   if(i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) return 0;
   if(n == 1) return 1;
   if(M[n][i][j] > 0) return M[n][i][j];
   M[n][i][j] = paths(M, i - 1, j - 2, n - 1) % max + // jump to a
                paths(M, i - 2, j - 1, n - 1) % max + // jump to b
                paths(M, i - 2, j + 1, n - 1) % max + // jump to c
                paths(M, i - 1, j + 2, n - 1) % max + // jump to d
                paths(M, i + 1, j + 2, n - 1) % max + // jump to e
                paths(M, i + 2, j + 1, n - 1) % max + // jump to f
                paths(M, i + 2, j - 1, n - 1) % max + // jump to g
                paths(M, i + 1, j - 2, n - 1) % max; // jump to h
   return M[n][i][j];
}
}