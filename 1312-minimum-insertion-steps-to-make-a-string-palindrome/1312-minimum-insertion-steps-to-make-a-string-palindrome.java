class Solution {

    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        sb.toString();
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == sb.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int plen = dp[n][n];
        return n - plen;
    }
}
