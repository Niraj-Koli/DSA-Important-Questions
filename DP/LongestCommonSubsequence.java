/*
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 */

public class LongestCommonSubsequence {
    public static int[][] dp;

    public static int longestCommonSubsequenceRecursive(String x, String y) {
        int n = x.length();
        int m = y.length();

        dp = new int[n + 1][m + 1];

        return lcs(x, y, n, m);
    }

    public static int lcs(String x, String y, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != 0) {
            return dp[n][m];
        }

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            dp[n][m] = 1 + lcs(x, y, n - 1, m - 1);

            return dp[n][m];
        } else {
            dp[n][m] = Math.max(lcs(x, y, n, m - 1), lcs(x, y, n - 1, m));

            return dp[n][m];
        }
    }

    public static int longestCommonSubsequenceIterative(String x, String y) {
        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int answer = longestCommonSubsequenceIterative(text1, text2);

        System.out.println(answer);
    }
}

// class Solution {
// public int longestCommonSubsequence(String text1, String text2) {
// int n = text1.length();
// int m = text2.length();

// int[] dp = new int[m + 1];

// for (int i = 1; i <= n; i++) {
// int prev = 0;
// for (int j = 1; j <= m; j++) {
// int temp = dp[j];
// if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
// dp[j] = prev + 1;
// } else {
// dp[j] = Math.max(dp[j], dp[j - 1]);
// }
// prev = temp;
// }
// }

// return dp[m];
// }
// }