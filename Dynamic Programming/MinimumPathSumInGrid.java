import java.util.*;

public class MinimumPathSumInGrid {
  public static int f(int i, int j, int[][] matrix, int[][] dp) {
    if (i == 0 && j == 0)
      return matrix[i][j];
    if (i < 0 || j < 0)
      return Integer.MAX_VALUE;

    if (dp[i][j] != -1)
      return dp[i][j];

    int up = f(i - 1, j, matrix, dp);
    int left = f(i, j - 1, matrix, dp);

    if (up != Integer.MAX_VALUE) {
      up += matrix[i][j];
    }
    if (left != Integer.MAX_VALUE) {
      left += matrix[i][j];
    }

    return dp[i][j] = (int) Math.min(up, left);
  }

  public static int tabulation(int m, int n, int[][] matrix, int[][] dp) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = matrix[i][j];
        } else {
          int up = Integer.MAX_VALUE;
          int left = Integer.MAX_VALUE;

          if (i > 0)
            up = matrix[i][j] + dp[i - 1][j];
          if (j > 0)
            left = matrix[i][j] + dp[i][j - 1];
          dp[i][j] = Math.min(up, left);
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  public static int spaceOptimized(int m, int n, int[][] matrix) {
    int[] prev = new int[n];
    for (int i = 0; i < m; i++) {
      int[] curr = new int[n];
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          curr[j] = matrix[i][j];
        } else {
          int up = Integer.MAX_VALUE;
          int left = Integer.MAX_VALUE;

          if (i > 0)
            up = matrix[i][j] + prev[j];
          if (j > 0)
            left = matrix[i][j] + curr[j - 1];

          curr[j] = Math.min(up, left);
        }
      }
      for (int ind = 0; ind < n; ind++) {
        prev[ind] = curr[ind];
      }
    }
    return prev[n - 1];
  }

  public static void main(String args[]) {
    int[][] matrix = new int[2][3];
    int m = 2, n = 3;
    matrix[0][0] = 5;
    matrix[0][1] = 9;
    matrix[0][2] = 6;
    matrix[1][0] = 11;
    matrix[1][1] = 5;
    matrix[1][2] = 2;
    int dp[][] = new int[2][3];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }
    // int res = f(m-1, n-1, matrix, dp);
    // int res = tabulation(m, n, matrix, dp);
    int res = spaceOptimized(m, n, matrix);
    System.out.println(res);
  }
}