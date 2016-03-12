/**
 * Created by qiqu on 2/20/16.
 */
public class KnightBoard {
    final static int[][] directions = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public int minStep(int[][] dp, int i, int j, int m, int n) {
        int min = -1, tmp, r = dp.length, c = dp[0].length;
        if (m > r - 1 || n > c - 1 || m < 0 || n < 0) return -1;
        if (dp[m][n] != 0) return dp[m][n];
        if (i == m && j == n) return 0;
        dp[m][n] = -1;
        for (int[] direction : directions) {
            tmp = minStep(dp, i, j, m + direction[0], n + direction[1]);
            if (tmp != -1) {
                if (min == -1) min = tmp + 1;
                else min = Math.min(min, tmp + 1);
                if (tmp == 0) break;
            }
        }
        dp[m][n] = min;
        return min;
    }

}
