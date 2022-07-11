class Solution {

    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for (int g = 0; g < n; g++) {
            for (int j = g, i = 0; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                    String temp = s.substring(i, j+1);
                    if (temp.length() > res.length()) {
                        res = temp;
                    }
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        String temp = s.substring(i, j+1);
                        if (temp.length() > res.length()) {
                            res = temp;
                        }
                    }
                } else {
                    char a = s.charAt(i);
                    char b = s.charAt(j);
                    if (a == b && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        String temp = s.substring(i, j+1);
                        if (temp.length() > res.length()) {
                            res = temp;
                        }
                    }
                }
            }
        }
        return res;
    }
}
